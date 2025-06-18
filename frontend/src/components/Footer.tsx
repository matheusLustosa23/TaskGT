
import { FaGithub } from "react-icons/fa";
import { SiLinkedin } from "react-icons/si";

import { FaSquareInstagram } from "react-icons/fa6";

export function Footer(){
    return(
        <div className="flex flex-col flex-1 h-full bg-white items-center justify-center gap-2 ">
            <div className="flex flex-row gap-2 w-4/12 items-center justify-center end">
               
                <FaGithub  className="size-6 rounded-2xl hover:text-gray-600"/>
                <SiLinkedin className="size-6 text-blue-700 hover:text-blue-500" />
                <FaSquareInstagram className="size-7 rounded-[500px]  text-fuchsia-500 hover:text-fuchsia-700" />
                
            </div>

            <div className="flex flex-col items-center justify-center w-full">
                <p className="text-black text-sm">© 2025 TaskGT. All rights reserved.</p>
                <p className="text-black text-sm">Made with by Matheus Lustosa</p>
            </div>

        </div>
    );
}