import { FaArrowLeft, FaArrowRight } from "react-icons/fa";
import type { PaginationType } from "../types/PaginationType";

export function TaskPagination({pagination,page,setPage}:{pagination:PaginationType,page:number,setPage:(page:number)=>void}){
    return(
        <div className='flex flex-row gap-2 justify-center items-center h-1/10'>

            <button >{pagination.hasPrevious?<FaArrowLeft onClick={()=>setPage(page-1)} />:<FaArrowLeft className='text-black/30 '/>}</button>
            <button className='font-bold text-2xl'>{pagination.page+1}</button>
            <button>{pagination.hasNext?<FaArrowRight onClick={()=>setPage(page+1)}  />:<FaArrowRight className='text-black/30 ' />}</button>

            
            
        </div>
    );
}