
import type React from "react";
import { Link } from "react-router-dom";

export function Buttom(
    {icon,width,children,className='',onClick,to,...rest}:
    {width?:string,children:React.ReactNode,className?:string,onClick?:()=>void,to?:string,icon?:React.ReactNode}
     & React.ButtonHTMLAttributes<HTMLButtonElement>) {

    const classBase = `bg-red-600 p-2   rounded-2xl ${width?width:'w-8/12 '} text-white whitespace-nowrap ${className} ${icon && 'flex flex-row'}`;
    

    if(to){
        return(
            <Link to={to}>
                <button className={classBase} {...rest}>
                      {children}
                      {icon}
                </button>
              
            </Link>
        );
    }

    if(onClick){
         return (
        <button className={classBase} 
        onClick={onClick} {...rest}>
            {children}
            {icon}
        
        </button>
    );
    }

    return (
        <button className={classBase}  {...rest}>
            {children}
            {icon}
           
        </button>
    );
}