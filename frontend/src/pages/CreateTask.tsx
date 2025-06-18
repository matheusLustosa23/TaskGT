import { Buttom } from "../components/Buttom";
import { Input } from "../components/Input";
export function CreateTarsk(){
 return(
        <div className="flex-1  flex  flex-col items-center gap-2 bg-gradient-to-r from-white via-red-400 to-red-600 justify-center">
           
            <form action="" method="post" className="w-2/12 shadow-2xl h-8/12 flex flex-col gap-2 items-center justify-evenly bg-white rounded-2xl">
            <legend>Create Task</legend>
         
                <Input placeholder="Descreva o Titulo" />
                <Input  placeholder="Insira uma descrição " />
                <div className="priority flex flex-row gap-3">
                <label htmlFor="prioridade">Priority:</label>
                <select name="prioridade" id="prioridade" className="border rounded-2xl p-1">
                    <option value="Low">Low</option>
                    <option value="Medium">Medium</option>
                    <option value="Hight">Hight</option>
                    <option value="Critical">Critical</option>
                  
                </select>
                </div>
                <div className="dead-line flex flex-col gap-3">
                <label htmlFor="deadLine">Dead Line:</label>
                     <Input name="deadLine" type="date" />
                </div>
          
               
               

          
             <Buttom>Save Task</Buttom>
            </form>
         
            </div>
     
       
    )

}