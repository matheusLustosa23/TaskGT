import { Link } from "react-router-dom";

export function AppLink({to,children,className=''}:{to:string,children:React.ReactNode,className?:string}){
    return(
        <Link to={to} className={`underline text-red-600 ${className}`}>
            {children}
        </Link>
    )

}