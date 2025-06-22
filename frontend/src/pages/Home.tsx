
import wallpaper from '../assets/images/TaskGt-walpapper3.png';
import { Wallpaper } from "../components/Wallpaper";
import { UseAuthContext } from '../context/auth/UseAuthContext';


export function Home(){

    const user = UseAuthContext().user

    return(
        <div className="flex-1  flex  flex-col items-center gap-2 bg-gradient-to-r from-white via-red-400 to-red-600 justify-center">
              <Wallpaper title='Welcome' highlightedText={` ${user?.username}`}  text='Got something in mind? Create your first task!' image={wallpaper} />
           
        </div>
     
       
    )

}