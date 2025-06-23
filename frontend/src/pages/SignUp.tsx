import { useState } from 'react';
import wallpaper from '../assets/images/TaskGt-walpapper.png';
import { AppLink } from '../components/AppLink';
import { Buttom } from '../components/Buttom';

import { Wallpaper } from '../components/Wallpaper';
import { UserService } from '../services/UserService';
import { useNavigate } from 'react-router-dom';
import { handleApiError } from '../errors/handleApiError';
import Modal from '../components/Modal';

export function SignUp() {

    const[password,setPassword]=useState<string>('')
    const[email,setEmail]=useState<string>('')
    const[username,setUsername]=useState<string>('')
    const[modal,setModal]=useState<{title:string,description:string,isSucess:boolean}|null>(null)
    const navigate = useNavigate()
 
    const closeModal = () => {
        if(modal?.isSucess){

            navigate("/login")
        }else{
         
        setModal(null)
    }
    }

  


    async function registerUser(e:React.FormEvent){
        e.preventDefault()
        try{
            await UserService.register({username:username,email:email,password:password})
            setModal({title:'Congratulations',description:'user registed successfully',isSucess:true});
           
        }catch(error:unknown){
            const message = handleApiError(error,'Error to register');
            setModal({title:'Error',description:message,isSucess:false});
           
        }
        
    }
    

    return(
        <div className="flex-1  flex shadow-2xl bg-gradient-to-r from-white via-white to-red-600">
        
        {modal &&  <Modal description={modal.description} title={modal.title} onClick={closeModal}  />}
        <Wallpaper image={wallpaper} />
        <div className='flex flex-col flex-1 justify-center items-center bg-grat '>
            
            <form onSubmit={registerUser} className='flex w-md h-8/12 flex-col gap-4 items-center justify-center shadow-2xl rounded-2xl bg-white'>
               
                <legend className='text-2xl'>Sign Up</legend>
                <input type="text" name="username" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Username' autoComplete='username' onChange={(e)=>setUsername(e.target.value)} />
                <input type="text" name="email" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Email' autoComplete='email' onChange={(e)=>setEmail(e.target.value)} />


     
                <input type="password" name="password" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Password' autoComplete='current-password' onChange={(e)=>setPassword(e.target.value)} />

    
                <Buttom type='submit'>Create Account</Buttom>
                
                <p>Already registered? <AppLink to='/login'>Login</AppLink> </p> 
            </form>

        </div>

    </div>
    )

}