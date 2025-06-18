
import wallpaper from '../assets/images/TaskGt-walpapper.png';
import { Wallpaper } from '../components/Wallpaper';
import { AppLink } from './AppLink';

function Login() {
  return (
    <div className="flex-1  flex shadow-2xl bg-gradient-to-r from-white via-white to-red-600">
        <Wallpaper image={wallpaper} />
        <div className='flex flex-col flex-1 justify-center items-center gap-6 bg-grat '>
            {/* <h2 className='text-2xl'>Enter with your credentials</h2> */}
            <form action="" method="post" className='flex w-md h-8/12 flex-col gap-6 items-center justify-center shadow-2xl rounded-2xl bg-white'>
                {/* <label className='text-xl' htmlFor="username">Username</label> */}
                <legend className='text-2xl'>Sign In</legend>
                <input type="text" name="username" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Username' />


                {/* <label className='text-xl' htmlFor="password">Password</label> */}
                <input type="password" name="password" className='p-1 focus:outline-none border rounded-2xl w-8/12' placeholder='Password' />
                <a href='#' className='underline text-red-600 self-end mr-4'>Forgot your password?</a>
                <button className='bg-red-600 p-2 rounded-2xl w-4/12 text-white'>Login</button>
             
                <p>Create Account<AppLink to='/signup'>Create Account</AppLink>
                </p> 
            </form>

        </div>

    </div>
  );
}

export default Login;























