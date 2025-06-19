import { Wallpaper } from "../components/Wallpaper";
import PageNotFound from '../assets/images/pageNotFound2.png';
import { Buttom } from "../components/Buttom";

export function NotFound(){
    return(
        <div className="flex flex-col items-center w-full justify-center">
            
   
            <Wallpaper title="404 Page Not Found " text="Oops! Looks like you got lost.The page you are looking for could not be found." image={PageNotFound} />
            <Buttom width="w-full" to="/" className="mb-4" >Back to home</Buttom>
        </div>
    );
}