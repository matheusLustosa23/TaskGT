import type { loguinRequestType } from "./LoginRequestType"
import type { UserType } from "./UserType"

export type AuhtContextType ={
    authenticated:boolean,
    login:(data:loguinRequestType)=>void,
    logout:()=>void,
    user:UserType
}