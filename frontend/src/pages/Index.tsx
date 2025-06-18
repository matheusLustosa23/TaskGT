import { Wallpaper } from "../components/Wallpaper";
import wallpaper from '../assets/images/TaskGt-walpapper4.png';

export function Index(){
    return(
        <div className="flex flex-1  bg-white items-center justify-center">
             <div className="w-8/10 h-full bg-white rounded-2xl flex flex-col items-center">

            <Wallpaper image={wallpaper} width={700} text="Organize your tasks, achieve your goals and manage your time like never before."/>
        </div>
           
           

        </div>
    );
}