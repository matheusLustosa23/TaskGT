import { Route, Routes } from "react-router-dom";
import { PrivateLayout } from "../layouts/PrivateLayout";
import { Home } from "../pages/Home";
import { CreateTarsk } from "../pages/CreateTask";
import { Navigate } from "react-router-dom";
import { NotFound } from "../pages/NotFound";

export function PrivateRoutes(){
      const auth=false;
  if(!auth){
    return <Navigate to={"/login"} />
  }

  console.log('rote private')

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