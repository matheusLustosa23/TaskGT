import { Routes,Route } from "react-router-dom";
import { PublicLayout } from "../components/PublicLayout";
import { Index } from "../pages/Index";
import Login from "../pages/Login";
import { SignUp } from "../pages/SignUp";

export function PublicRoutes(){
    return(
        <PublicLayout>
            <Routes>
                <Route path="/" element={<Index />} />
                <Route path="/login" element={<Login />} />
                <Route path="/signup" element={<SignUp />} />
            </Routes>
        </PublicLayout>
    );
    
}