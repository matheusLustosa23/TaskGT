
import { useState } from 'react';
import wallpaper from '../assets/images/TaskGt-walpapper.png';
import { Buttom } from '../components/Buttom';
import { Wallpaper } from '../components/Wallpaper';
import { AppLink } from './AppLink';
import { UseAuthContext } from '../context/auth/UseAuthContext';

function Login() {

  const login=UseAuthContext().login

  const[username,setUsername]=useState('')
  const[password,setPassword]=useState('')
  function HandleLogin(event:React.FormEvent){
    event.preventDefault()
    if(!username.trim() || !password.trim()){
      alert('Please ,Complete all camps')
    }

    login({username,password})

    

  }

  return (
    <div className="flex-1  flex shadow-2xl bg-gradient-to-r from-white via-white to-red-600">
        <Wallpaper image={wallpaper} />
        <div className='flex flex-col flex-1 justify-center items-center gap-6 bg-grat '>
            {/* <h2 className='text-2xl'>Enter with your credentials</h2> */}
            <form onSubmit={HandleLogin} className='flex w-md h-8/12 flex-col gap-6 items-center justify-center shadow-2xl rounded-2xl bg-white'>
                {/* <label className='text-xl' htmlFor="username">Username</label> */}
                <legend className='text-2xl'>Sign In</legend>
                <input type="text" name="username" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Username' value={username} onChange={(e)=>setUsername(e.target.value)}/>


                {/* <label className='text-xl' htmlFor="password">Password</label> */}
                <input type="password" name="password" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Password' value={password} onChange={(e)=>setPassword(e.target.value)} />
              
                <AppLink to='#'>Forgot your password?</AppLink>
                {/* <button className='bg-red-600 p-2 rounded-2xl w-4/12 text-white'>Login</button> */}
                <Buttom type='submit'>Login</Buttom>
             
               <AppLink to='/signup'>Create Account</AppLink>
              
            </form>

        </div>

    </div>
  );
}

export default Login;























