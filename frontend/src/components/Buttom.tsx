import type React from "react";
import { Link } from "react-router-dom";

export function Buttom({width,children,className='',onClick,to}:{width?:string,children:React.ReactNode,className?:string,onClick?:()=>void,to?:string}) {

    const classBase = `bg-red-600 p-2  rounded-2xl ${width?width:'w-8/12 '} text-white whitespace-nowrap ${className}`;

    if(to){
        return(
            <Link to={to}>
                <button className={classBase} >
                      {children}
                </button>
              
            </Link>
        );
    }

    return (
        <button className={classBase} 
        onClick={() => onClick}>
            {children}
        
        </button>
    );
}