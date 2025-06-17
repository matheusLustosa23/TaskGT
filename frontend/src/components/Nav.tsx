import { ImExit } from "react-icons/im";
import { MdAdd } from "react-icons/md";
export function Nav(){
    return(
        <nav className="flex flex-1 h-full  flex-row bg-white justify-between">
        
        
        <div className="p-4 flex flex-col items-start justify-center w-2/12">
             <p className="text-4xl">Task<span className="text-red-600 font-sans text-4xl underline">GT</span></p> 
        </div>
      

        <div className="flex flex-row w-2/12 justify-evenly  items-center gap-1 mr-3">
            <button className="p-3 bg-red-600 rounded-2xl h-1/2 flex-1 text-white flex flex-row gap-2 items-center justify-between text-nowrap">New Task<MdAdd className="size-6" /></button>

            <button className="p-3 bg-red-600 rounded-2xl h-1/2 flex-1 text-white flex flex-row gap-2 items-center justify-between"  >Logout <ImExit className="size-6" /> </button>
           

        </div>
      
           


        </nav>
    )
}