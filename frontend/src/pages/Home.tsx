
import { useEffect, useState } from 'react';
import wallpaper from '../assets/images/TaskGt-walpapper3.png';
import { Wallpaper } from "../components/Wallpaper";
import { UseAuthContext } from '../context/auth/UseAuthContext';
import { GrEdit } from "react-icons/gr";
import type { PaginationType } from '../types/PaginationType';
import { TaskService } from '../services/TaskService';
import type { ApiResponseType } from '../types/ApiReponseType';
import type { PaginationResponseType } from '../types/PaginationResponseType';
import type { TaskType } from '../types/TaskType';
import { FaArrowRight,FaArrowLeft } from "react-icons/fa";
import { MdDelete } from "react-icons/md";

import type { RegisterTaskRequestType } from '../types/RegisterTaskRequestType';


import Modal from '../components/Modal';
import { handleApiError } from '../errors/handleApiError';
import { FaSave } from "react-icons/fa";

export function Home(){

    const user = UseAuthContext().user
    const[tasks,setTasks] = useState<TaskType[] | null>(null)
    const[pagination,setPagination] = useState<PaginationType | null>(null)
    const[page,setPage] = useState<number>(0)
    const[modal,setModal]=useState<{title:string,description:string,isSucess:boolean} | null>(null)
    const[newTask,setNewTask]=useState<RegisterTaskRequestType>({
        title:'',
        description:'',
        priority:'LOW',
        deadLine:''
    })

    const closeModal = () =>{
        setModal(null)
    }

    

    const registerTask = async() => {
        try{
            await TaskService.registerTask(newTask)
            getTasks()

        }catch(error:unknown){
            const message = handleApiError(error,'Error to register Task')
                setModal({
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
            console.log('tasks:',items)
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


    useEffect(()=>{
        getTasks()
    },[page])




    

   
    if(tasks && pagination && tasks.length > 0){
        const classBaseRow= 'px-4 py-2 whitespace-nowrap overflow-hidden text-ellipsis'
        return (
        <div className='bg-gradient-to-r from-white via-red-400 to-red-600 flex flex-1 flex-col justify-between items-center '>
             {modal && <Modal title={modal.title} description={modal.description} onClick={closeModal} />}
            <table className='h-auto bg-white w-7/10 rounded-2xl table-fixed'>
            <thead className='bg-black text-white'>
                <tr >
                    <th className={`text-left w-1/15  ${classBaseRow}`}>Id</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>Title</th>
                    <th className={`text-left w-4/15 ${classBaseRow}`}>Description</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>Priority</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>status</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>Dead Line</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>Actions</th>
                    
                </tr>
            </thead>
            
            <tbody>
                {tasks && tasks.map(
                    task => <tr className="odd:bg-gray-300 even:bg-white" key={task.id} >
                        <td className={`${classBaseRow}`}>{task.id}</td>
                        <td className={`${classBaseRow}`}>{task.title}</td>
                        <td className={`${classBaseRow}`}>{task.description}</td>
                        <td className={`${classBaseRow}`}>{task.priority}</td>
                        <td className={`${classBaseRow}`}>{task.status}</td>
                        <td className={`${classBaseRow}`}>{task.deadLine}</td>
                        <td className={`${classBaseRow} flex flex-row gap-5`}><GrEdit /> <MdDelete /></td>
                      
                       
                    </tr>
                    
                )}
                

            </tbody>
            <tfoot>
                <tr className="bg-blue-100"> 
                    <td className={`${classBaseRow}`}> 
                        <input type="checkbox" className="mx-auto block"  /> 
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="text"
                            name="title"
                            placeholder="Título"
                            className="w-full p-1 border rounded"
                            value={newTask.title}
                            onChange={(e)=>{setNewTask(x=>({...x,title:e.target.value}))}}
                        />
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="text"
                            name="description"
                            placeholder="Descrição"
                            className="w-full p-1 border rounded"
                            value={newTask.description}
                            onChange={(e)=>{setNewTask(x=>({...x,description:e.target.value}))}}
                        />
                    </td>
                    <td className={`${classBaseRow}`}>

                    <select name="prioridade" id="prioridade" className="border rounded-2xl p-1" onChange={(e)=>{setNewTask(x=>({...x,priority:e.target.value}))}} value={newTask.priority}>
                        <option value="LOW">Low</option>
                        <option value="MEDIUM">Medium</option>
                        <option value="HIGH">High</option>
                        <option value="CRITICAL">Critical</option>
                    
                    </select>
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="ext"
                            name="status"
                            placeholder="Status"
                            className="w-full p-1 border rounded"
                            value={"TO_DO"}
                            disabled
                        />
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="date" 
                            name="deadLine"
                            placeholder="Dead Line"
                            className="w-full p-1 border rounded"
                            onChange={(e)=>{setNewTask(x=>({...x,deadLine:e.target.value}))}}
                            value={newTask.deadLine}
                        />
                    </td>
                    <td className={`${classBaseRow} text-center`}>
                        <button className="text-green-600 hover:text-green-800" onClick={registerTask}>
                            <FaSave  size={30} className="mx-auto" /> 
                        </button>
                    </td>
                </tr>
            </tfoot>

            </table>
                

               
          
                <div className='flex flex-row gap-2 justify-center items-center h-1/10'>

                    <button >{pagination.hasPrevious?<FaArrowLeft onClick={()=>setPage(page-1)} />:<FaArrowLeft className='text-black/30 '/>}</button>
                    <button className='font-bold text-2xl'>{pagination.page+1}</button>
                    <button>{pagination.hasNext?<FaArrowRight onClick={()=>setPage(page+1)}  />:<FaArrowRight className='text-black/30 ' />}</button>

                   
                  
                </div>
            
       </div>
        )
    }

    return(

        
        <div className="flex-1  flex  flex-col items-center gap-2 bg-gradient-to-r from-white via-red-400 to-red-600 justify-center">
              <Wallpaper title='Welcome ' highlightedText={user?.username}  text='Got something in mind? Create your first task!' image={wallpaper} />

           
        </div>
     
       
    )

}