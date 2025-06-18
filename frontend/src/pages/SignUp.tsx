import wallpaper from '../assets/images/TaskGt-walpapper.png';
import { Wallpaper } from '../components/Wallpaper';
import { AppLink } from './AppLink';
export function SignUp() {
    return(
            <div className="flex-1  flex shadow-2xl bg-gradient-to-r from-white via-white to-red-600">

        <Wallpaper image={wallpaper} />
        <div className='flex flex-col flex-1 justify-center items-center bg-grat '>
            
            <form action="" method="post" className='flex w-md h-8/12 flex-col gap-4 items-center justify-center shadow-2xl rounded-2xl bg-white'>
               
                <legend className='text-2xl'>Sign Up</legend>
                <input type="text" name="username" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Username' />
                <input type="text" name="email" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Email' />


     
                <input type="password" name="password" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Password' />

                <button className='bg-red-600 p-2 rounded-2xl w-4/12 text-white'>Create Account</button>
                <p>Already registered? <AppLink to='/login'>Login</AppLink> </p> 
            </form>

        </div>

    </div>
    )

}