import { Buttom } from "./Buttom";

export default function Modal({title,description,onClick}:{title?:string,description:string,onClick:()=>void}){

    return(

        <div className="fixed top-0 left-0 w-full h-full bg-black/50 flex flex-col items-center justify-center text-center">
            <div className="bg-white w-3/10 h-4/10 rounded-2xl flex flex-col justify-evenly gap-7 items-center p-3">
                <h1 className="text-3xl text-red-600">{title?title:'Error'}</h1>
                <p className="text-[20px]">{description?description:'your description here'}</p>
                <Buttom onClick={onClick} >Close</Buttom>
            </div>
        </div>
    )
   


}