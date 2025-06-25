import { GrEdit } from "react-icons/gr"
import { MdDelete } from "react-icons/md"
// import Modal from "./Modal"
import type { TaskType } from "../types/TaskType"
import type { RegisterTaskRequestType } from "../types/RegisterTaskRequestType"
import TaskInput from "./TaskInput"

export function TaskTable(
    {tasks,deleteTask,newTask,setNewTask,registerTask}:
    {tasks:TaskType[],deleteTask:(id:number)=>void,newTask:RegisterTaskRequestType,setNewTask:React.Dispatch<React.SetStateAction<RegisterTaskRequestType>>,registerTask:()=>void}){
        const classBaseRow= 'px-4 py-2 whitespace-nowrap overflow-hidden text-ellipsis'
        return (
        <div className='bg-gradient-to-r from-white via-red-400 to-red-600 flex flex-1 flex-col justify-between items-center '>
             {/* {modal && <Modal title={modal.title} description={modal.description} onClick={closeModal} />} */}
            <table className='h-auto bg-white w-7/10 rounded-2xl table-fixed'>
           { tasks  && tasks.length > 0 &&  <thead className='bg-black text-white'>
                <tr >
                    <th className={`text-left w-1/15  ${classBaseRow}`}></th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>Title</th>
                    <th className={`text-left w-4/15 ${classBaseRow}`}>Description</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>Priority</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>status</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>Dead Line</th>
                    <th className={`text-left w-2/15 ${classBaseRow}`}>Actions</th>
                    
                </tr>
            </thead>}
           
            
            <tbody>
                {tasks && tasks.map(
                    task => <tr className="odd:bg-gray-300 even:bg-white" key={task.id} >
                        <td className={`${classBaseRow}`}></td>
                        <td className={`${classBaseRow}`}>{task.title}</td>
                        <td className={`${classBaseRow}`}>{task.description}</td>
                        <td className={`${classBaseRow}`}>{task.priority}</td>
                        <td className={`${classBaseRow}`}>{task.status}</td>
                        <td className={`${classBaseRow}`}>{task.deadLine}</td>
                        <td className={`${classBaseRow} flex flex-row gap-5`}><GrEdit /> <MdDelete onClick={()=>deleteTask(task.id)} /></td>
                      
                       
                    </tr>
                    
                )}
                

            </tbody>
            <tfoot>
               <TaskInput newTask={newTask} setNewTask={setNewTask} registerTask={registerTask} />
            </tfoot>

            </table>
                

               
          

            
       </div>
        )

}