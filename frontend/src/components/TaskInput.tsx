import { FaSave } from "react-icons/fa"
import type { RegisterTaskRequestType } from "../types/RegisterTaskRequestType"

export default function TaskInput({newTask,setNewTask,registerTask}:{newTask:RegisterTaskRequestType,setNewTask:React.Dispatch<React.SetStateAction<RegisterTaskRequestType>>,registerTask:()=>void}){
    const classBaseRow= 'px-4 py-2 whitespace-nowrap overflow-hidden text-ellipsis'
    return(
       
        <tr className="bg-blue-100"> 
            <td className={`${classBaseRow}`}> 
               
            </td>
            <td className={`${classBaseRow}`}>
                <input
                    type="text"
                    name="title"
                    placeholder="Title"
                    className="w-full p-1 border rounded"
                    value={newTask.title}
                    onChange={(e)=>{setNewTask(x=>({...x,title:e.target.value}))}}
                />
            </td>
            <td className={`${classBaseRow}`}>
                <input
                    type="text"
                    name="description"
                    placeholder="Description"
                    className="w-full p-1 border rounded"
                    value={newTask.description}
                    onChange={(e)=>{setNewTask(x=>({...x,description:e.target.value}))}}
                />
            </td>
            <td className={`${classBaseRow}`}>

            <select name="priority" id="priority" className="border rounded-2xl p-1" onChange={(e)=>{setNewTask(x=>({...x,priority:e.target.value}))}} value={newTask.priority}>
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
       
    )
}