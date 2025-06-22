
import { AuthContext } from "./AuthContext"
import { AuthService } from "../../services/AuthService"
import type { loguinRequestType } from "../../types/LoginRequestType";
import { useEffect, useState } from "react";
import { handleApiError } from "../../errors/handleApiError";
import type { ProfileType } from "../../types/ProfileType";
import { UserService } from "../../services/UserService";


export function AuthProvider({children}:{children:React.ReactNode}){

    const [auth,setAuth]=useState(false)
    const [profile,setProfile]=useState<ProfileType | null>(null)

    const loadProfile = async() =>{
        try{
            const profileResponse = await UserService.getProfile()
            const profile = profileResponse.data || null
            setProfile(profile)
        }catch(error:unknown){
            const err = handleApiError(error,'error loading profile')
            HandleLogout()
            alert(err)
        }
    }

    useEffect(()=>{
        const token=localStorage.getItem('token')
        if(token){
            setAuth(true)
            loadProfile()
        }

    },[]);
    
    


    async function HandleLogin(data:loguinRequestType){

        try{
            const response = await AuthService.login(data);
            const token=response.data?.token
            if(token){
                setAuth(true)
                localStorage.setItem('token',token)
                await loadProfile()

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
        setProfile(null)

    }



    return(
        <AuthContext.Provider value={{authenticated:auth,login:HandleLogin,logout:HandleLogout,user:profile}}>
            {children}
        </AuthContext.Provider>
    )

}