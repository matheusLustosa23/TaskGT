import { Route, Routes } from "react-router-dom";
import { PrivateLayout } from "../components/PrivateLayout";
import { Home } from "../pages/Home";
import { CreateTarsk } from "../pages/CreateTask";
import { Navigate } from "react-router-dom";

export function PrivateRoutes(){
      const auth=false;
  if(!auth){
    return <Navigate to={"/login"} />
  }

    return(
        <PrivateLayout>
            <Routes>
                <Route path="/" element={<Home />} />   
                <Route path="/task" element={<CreateTarsk />} />   
            </Routes>
        </PrivateLayout>
    )
}