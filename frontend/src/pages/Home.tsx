
import wallpaper from '../assets/images/TaskGt-walpapper3.png';
import { Wallpaper } from "../components/Wallpaper";


export function Home(){

    return(
        <div className="flex-1  flex  flex-col items-center gap-2 bg-gradient-to-r from-white via-red-400 to-red-600 justify-center">
              <Wallpaper title='No tasks found.' text='Got something in mind? Create your first task!' image={wallpaper} />
           
        </div>
     
       
    )

}