
import { NotFound } from "../pages/NotFound";
import { PrivateRoutes } from "./PrivateRoutes";
import { PublicRoutes } from "./PublicRoutes";
import { Routes,Route } from "react-router-dom";

export function AppRoutes() {

   return(
        <Routes>
            <Route path="/*" element={<PublicRoutes />} />
            <Route path="/app*" element={<PrivateRoutes />} />
            <Route path="*" element={<NotFound />} />
        </Routes>
    )
}