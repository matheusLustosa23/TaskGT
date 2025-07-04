import { MdAdd } from "react-icons/md";
import { ButtomNav } from "../components/ButtomNav";
import { Footer } from "../components/Footer";
import { ImExit } from "react-icons/im";
import { Nav } from "../components/Nav";
import { UseAuthContext } from "../context/auth/UseAuthContext";

export function PrivateLayout({ children }: { children: React.ReactNode }) {

   const logout=UseAuthContext().logout

 return (
    <div className="flex flex-col min-h-screen">
         <nav className="h-28 border-b-1 border-gray-200 ">
           <Nav>
              <ButtomNav icon={<MdAdd className="size-6" />} to="/app/task">
                  New Task
                </ButtomNav>
                <ButtomNav  icon={<ImExit className="size-6" />} onClick={logout}>
                    Logout
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