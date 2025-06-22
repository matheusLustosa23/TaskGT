import { Routes,Route } from "react-router-dom";
import { PublicLayout } from "../layouts/PublicLayout";
import { Index } from "../pages/Index";
import Login from "../pages/Login";
import { SignUp } from "../pages/SignUp";
import { Navigate } from "react-router-dom";
import { NotFound } from "../pages/NotFound";
import { UseAuthContext } from "../context/auth/UseAuthContext";

export function PublicRoutes(){

    const context=UseAuthContext()
    if(context.authenticated){
        return <Navigate to={'/app'} />
    }



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