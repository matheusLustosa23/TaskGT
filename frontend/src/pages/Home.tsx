
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
import { FiFilePlus } from "react-icons/fi";

export function Home(){

    const user = UseAuthContext().user
    const[tasks,setTasks] = useState<TaskType[] | null>(null)
    const[pagination,setPagination] = useState<PaginationType | null>(null)
    const[page,setPage] = useState<number>(0)

    const getTasks = async() => {
        try {
            const response:ApiResponseType<PaginationResponseType<TaskType[]>> = await TaskService.getAll({page:page,pageSize:10})
            const items:TaskType[] | null = response.data?.items || null
            const paginationResponse:PaginationType | null = response.data?.pagination || null
            console.log('tasks:',items)
            setTasks(items)
            setPagination(paginationResponse)
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
                        <input type="checkbox" className="mx-auto block" /> 
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="text"
                            name="title"
                            placeholder="Título"
                            className="w-full p-1 border rounded"
                        />
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="text"
                            name="description"
                            placeholder="Descrição"
                            className="w-full p-1 border rounded"
                        />
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="text"
                            name="priority"
                            placeholder="Prioridade"
                            className="w-full p-1 border rounded"
                        />
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="text"
                            name="status"
                            placeholder="Status"
                            className="w-full p-1 border rounded"
                        />
                    </td>
                    <td className={`${classBaseRow}`}>
                        <input
                            type="date" 
                            name="deadLine"
                            placeholder="Dead Line"
                            className="w-full p-1 border rounded"
                        />
                    </td>
                    <td className={`${classBaseRow} text-center`}>
                        <button className="text-green-600 hover:text-green-800">
                            <FiFilePlus size={20} className="mx-auto" /> 
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