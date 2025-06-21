// import type { ApiResponseType } from "./ApiReponseType"
import type { loguinRequestType } from "./LoginRequestType"
// import type { LoginResponseType } from "./LoginResponseType"
import type { UserType } from "./UserType"

export type AuhtContextType ={
    authenticated:boolean,
    login:(data:loguinRequestType)=>Promise<void>,
    logout:()=>void,
    user:UserType | null
}