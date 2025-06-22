import { Route, Routes } from "react-router-dom";
import { PrivateLayout } from "../layouts/PrivateLayout";
import { Home } from "../pages/Home";
import { CreateTarsk } from "../pages/CreateTask";
import { Navigate } from "react-router-dom";
import { NotFound } from "../pages/NotFound";
import { UseAuthContext } from "../context/auth/UseAuthContext";

export function PrivateRoutes(){
const context=UseAuthContext()
    
  if(!context.authenticated){
    return <Navigate to={"/login"} />
  }



    return(
        <PrivateLayout>
            <Routes>
                <Route path="/" element={<Home />} />   
                <Route path="/task" element={<CreateTarsk />} />   
                <Route path="/*" element={<NotFound />} />
            </Routes>
        </PrivateLayout>
    )
}