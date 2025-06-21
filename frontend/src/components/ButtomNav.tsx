import React from "react";
import { Link } from "react-router-dom";

export function ButtomNav({icon,to,children,onClick}:{icon?:React.ReactNode, to?:string,children?:React.ReactNode,onClick?:()=>void})
{

    const baseClasses = "p-3 bg-red-600 rounded-2xl h-1/2 flex-1 text-white flex flex-row  items-center justify-center hover:bg-red-700 "
    
        if(onClick){
            return(
                <button className={`flex flex-row gap-4 ${baseClasses}`} onClick={onClick}>
                    {children}
                    {icon}
                </button>
            );
        }

        if(to){
        return(
            <Link to={to} className={baseClasses}>
                <button className='flex flex-row gap-4'>
                    {children}
                    {icon}
                </button>
            </Link>

        );
    }

    return(
        <button className={`flex flex-row gap-4 ${baseClasses}`} >
            {children}
            {icon}
        </button>
    );

    

}