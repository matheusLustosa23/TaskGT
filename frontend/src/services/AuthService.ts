import type { ApiResponseType } from "../types/ApiReponseType";
import type { loguinRequestType } from "../types/LoginRequestType";
import type { LoginResponseType } from "../types/LoginResponseType";
import { api } from "./api";

export const AuthService = {

    login:async function login(data:loguinRequestType):Promise<ApiResponseType<LoginResponseType>> {
       
        const response = await api.post<ApiResponseType<LoginResponseType>>('/login',data)
        return response.data
    }

};

