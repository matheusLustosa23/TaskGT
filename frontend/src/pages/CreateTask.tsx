
import { useNavigate } from "react-router-dom";
import { Buttom } from "../components/Buttom";
import { Input } from "../components/Input";
import type { RegisterTaskRequestType } from "../types/RegisterTaskRequestType";
import { TaskService } from "../services/TaskService";
import { handleApiError } from "../errors/handleApiError";
import { useState } from "react";
import Modal from "../components/Modal";
export function CreateTarsk(){
    const navigate = useNavigate()
    const[modal,setModal]=useState<{title:string,descripton:string,isSucess:boolean} | null>(null)
    const[task,SetTask]=useState<RegisterTaskRequestType>({
    title: '',
    description: '',
    priority: 'LOW',
    deadLine: ''
})
    const closeModal = () => {
        if(modal?.isSucess){
            navigate(-1)
        }else{
            setModal(null)
        }
    }

    const registerTask = async() => {
        try{
            const response = await TaskService.registerTask(task) 
            const message = response.summary.message
            console.log('task:',task.title)
            setModal({
                    title:'Congratulations',
                    descripton:message,
                    isSucess:true
                }
            )
        }catch(error:unknown){
            const message = handleApiError(error,'error to create task')
                    setModal({
                    title:'Error',
                    descripton:message,
                    isSucess:false
                })

        }
        
    }
    
 return(
        <div className="flex-1 relative  flex  flex-col items-center gap-2 bg-gradient-to-r from-white via-red-400 to-red-600 justify-center">
            {modal && <Modal title={modal.title} description={modal.descripton} onClick={closeModal} /> }
            <div className="absolute left-2 top-2 w-full">
                 <Buttom width="w-1/15" onClick={() => navigate(-1)}>Back</Buttom>
            </div>
            <form onSubmit={registerTask} className="w-2/12 shadow-2xl h-8/12 flex flex-col gap-2 items-center justify-evenly bg-white rounded-2xl">
            <legend>Create Task</legend>
         
                <Input placeholder="Descreva o Titulo"  onChange={(e)=>{SetTask(x => ({...x,title:e.target.value}))}}  />
                <Input  placeholder="Insira uma descrição" onChange={(e)=>{SetTask(x => ({...x,description:e.target.value}))}} />
                <div className="priority flex flex-row gap-3"> 
                <label htmlFor="prioridade">Priority:</label>
                <select name="prioridade" id="prioridade" className="border rounded-2xl p-1" onChange={(e)=>{SetTask(x => ({...x,priority:e.target.value}))}}>
                    <option value="LOW">Low</option>
                    <option value="MEDIUM">Medium</option>
                    <option value="HIGH">High</option>
                    <option value="CRITICAL">Critical</option>
                  
                </select>
                </div>
                <div className="dead-line flex flex-col gap-3">
                <label htmlFor="deadLine">Dead Line:</label>
                     <Input name="deadLine" type="date" onChange={(e)=>{SetTask(x => ({...x,deadLine:e.target.value}))}} />
                </div>
          
               
               

          
             <Buttom  type="submit">Save Task</Buttom>
            </form>
         
            </div>
     
       
    )

}