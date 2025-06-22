import { createContext } from "react";
import type { AuhtContextType } from "../../types/AuthContextType";

export const AuthContext = createContext<AuhtContextType | undefined>(undefined) 