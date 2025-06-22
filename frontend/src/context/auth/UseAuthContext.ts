
import { useContext } from "react";
import { AuthContext } from "./AuthContext";



export function UseAuthContext(){
    const context = useContext(AuthContext)
    if(context === undefined ){
        throw new Error('Context invalid')
    }

    return context;

}