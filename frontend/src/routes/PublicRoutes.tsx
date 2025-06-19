import { Routes,Route } from "react-router-dom";
import { PublicLayout } from "../layouts/PublicLayout";
import { Index } from "../pages/Index";
import Login from "../pages/Login";
import { SignUp } from "../pages/SignUp";
import { Navigate } from "react-router-dom";
import { NotFound } from "../pages/NotFound";

export function PublicRoutes(){

    const auth=false;
    if(auth){
        return <Navigate to={'/app'} />
    }

    console.log('rote public')

    return(
        <PublicLayout>
            <Routes>
                <Route path="/" element={<Index />} />
                <Route path="/login" element={<Login />} />
                <Route path="/signup" element={<SignUp />} />
                <Route path="/*" element={<NotFound />} />
            </Routes>
        </PublicLayout>
    );
    
}