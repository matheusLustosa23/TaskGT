
import { useEffect, useState } from 'react';
import wallpaper from '../assets/images/TaskGt-walpapper3.png';
import { Wallpaper } from "../components/Wallpaper";
import { UseAuthContext } from '../context/auth/UseAuthContext';

import type { PaginationType } from '../types/PaginationType';
import { TaskService } from '../services/TaskService';
import type { ApiResponseType } from '../types/ApiReponseType';
import type { PaginationResponseType } from '../types/PaginationResponseType';
import type { TaskType } from '../types/TaskType';


import type { RegisterTaskRequestType } from '../types/RegisterTaskRequestType';


import Modal from '../components/Modal';
import { handleApiError } from '../errors/handleApiError';

import type { DeleteTask } from '../types/DeleteTaskType';
import { TaskTable } from '../components/TaskTable';
import { TaskPagination } from '../components/TaskPagination';

export function Home(){

    const user = UseAuthContext().user
    const[tasks,setTasks] = useState<TaskType[] | null>(null)
    const[pagination,setPagination] = useState<PaginationType | null>(null)
    const[page,setPage] = useState<number>(0)
    const[modalState,setModalState]=useState<{title:string,description:string,isSucess:boolean} | null>(null)
    const[newTask,setNewTask]=useState<RegisterTaskRequestType>({
        title:'',
        description:'',
        priority:'LOW',
        deadLine:''
    })

    const closeModalState = () =>{
        setModalState(null)
    }

    const registerTask = async() => {
        try{
         
            await TaskService.registerTask(newTask)
            setPage((prev)=>tasks?.length===10?prev+1:prev)
      
            
        }catch(error:unknown){
            const message = handleApiError(error,'Error to register Task')
                setModalState({
                title:"Error",
                description:message,
                isSucess:false
            
            })
        }
      
    }

    const getTasks = async() => {
        try {
            const response:ApiResponseType<PaginationResponseType<TaskType[]>> = await TaskService.getAll({page:page,pageSize:10})
            const items:TaskType[] | null = response.data?.items || null
            const paginationResponse:PaginationType | null = response.data?.pagination || null
            setTasks(items)
            setPagination(paginationResponse)
            setNewTask({
                title:'',
                description:'',
                priority:'LOW',
                deadLine:''
            })
        } catch (error:unknown) {
            console.log(error)
        }
    }

    const deleteTask = async(id:number) => {
        try{
            const isConfirm = confirm("Are you sure you want to delete this task?")
            if(isConfirm){
                const response:ApiResponseType<DeleteTask> = await TaskService.deleteById(id)
                const isDeleted = response.data?.deleted
                const message = response.summary.message
                if(!isDeleted){
                    setModalState({
                        title:"Error",
                        description:message,
                        isSucess:false
                    
                    })

                    return
                }
                console.log('chegou onde n devia')
                setPage((prev)=>tasks?.length===1?prev-1:prev)

            }
            
           
        }catch(error:unknown){
            const message = handleApiError(error,'error to delete task')
                      
            setModalState({
                title:"Error",
                description:message,
                isSucess:false
            
            })
            
        }
    }


    useEffect(()=>{
        getTasks()
        
    },[page])



    //render Tasks
    if(tasks && pagination && tasks.length > 0){
     
        return (
        <div className='bg-gradient-to-r from-white via-red-400 to-red-600 flex flex-1 flex-col justify-between items-center '>
            
             {modalState && <Modal title={modalState.title} description={modalState.description} onClick={closeModalState} />}
            <TaskTable tasks={tasks} deleteTask={deleteTask} newTask={newTask} registerTask={registerTask} setNewTask={setNewTask} />
            <TaskPagination page={page} pagination={pagination} setPage={setPage} />
                
        </div>
        )
    }

    return(
        <div className="flex-1  flex  flex-col items-center gap-2 bg-gradient-to-r from-white via-red-400 to-red-600 justify-center">
              <Wallpaper title='Hello ' highlightedText={`${user?.username}!!!`} text='Got something in mind? Create your first task!' image={wallpaper} />

           
        </div>
     
       
    )

}