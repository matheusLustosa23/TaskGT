

import { ButtomNav } from "./ButtomNav";
import { Footer } from "./Footer";

import { Nav } from "./Nav";
import { FiLogIn, FiUserPlus } from 'react-icons/fi'; 

export function PublicLayout({ children }: { children: React.ReactNode }) {
      return (
        <div className="flex flex-col min-h-screen">
             <nav className="h-28 border-b-1 border-gray-200 ">
               <Nav>
                    <ButtomNav icon={<FiLogIn className="size-6" />} link="#">
                        Sign In
                    </ButtomNav>
                    <ButtomNav icon={<FiUserPlus className="size-6" />} link="#">
                        Sign Up
                    </ButtomNav> 
                </Nav>
             </nav>
       
             <main className="flex-1 flex ">
                {children} 
             </main>
       
             <footer className="h-32 shadow-2xl shadow-black">
               <Footer />
            </footer>
           
           </div>
    
      );

}