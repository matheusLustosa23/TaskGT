import React from "react";
import { Link } from "react-router-dom";

export function ButtomNav({icon,link,children}:{icon?:React.ReactNode, link:string,children?:React.ReactNode})
{

    const baseClasses = "p-3 bg-red-600 rounded-2xl h-1/2 flex-1 text-white flex flex-row gap-2 items-center justify-between text-nowrap hover:bg-red-700 "
    

        return(
            <Link to={link}>
                <button className={baseClasses}>
                    {children}
                    {icon}
                </button>
            </Link>

        );

    

}