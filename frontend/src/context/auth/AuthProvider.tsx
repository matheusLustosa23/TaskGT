import type { AuhtContextType } from "../../types/AuthContextType"
import { AuthContext } from "./AuthContext"
import { AuthService } from "../../services/AuthService"
import type { loguinRequestType } from "../../types/LoginRequestType";
import { useEffect, useState } from "react";
import { handleApiError } from "../../errors/handleApiError";


export function AuthProvider({children}:{children:React.ReactNode}){

    const [auth,setAuth]=useState(false)

    useEffect(()=>{
        const token=localStorage.getItem('token')
        if(token){
            setAuth(true)
        }
    },[]);
    
    


    async function HandleLogin(data:loguinRequestType){

        try{
            const response = await AuthService.login(data);
            const token=response.data?.token
            if(token){
                setAuth(true)
                localStorage.setItem('token',token)
            }
            
            console.log(`dados recebidos ${response}`)
        }catch(error:unknown){
            const err=handleApiError(error,'error login')
            alert(err)
        }
     
        
    }

    function HandleLogout(){
        localStorage.removeItem('token')
        setAuth(false)

    }





  
    const authExample:AuhtContextType = {
        authenticated:auth,
        login:HandleLogin,
        logout:HandleLogout,
        user:{id:'',username:'',roles:['']} //obs
    }

    return(
        <AuthContext.Provider value={authExample}>
            {children}
        </AuthContext.Provider>
    )

}