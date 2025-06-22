
import type { loguinRequestType } from "./LoginRequestType"
import type { ProfileType } from "./ProfileType"


export type AuhtContextType ={
    authenticated:boolean,
    login:(data:loguinRequestType)=>Promise<void>,
    logout:()=>void,
    user:ProfileType | null
}