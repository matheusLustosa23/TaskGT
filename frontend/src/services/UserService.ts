import type { ApiResponseType } from "../types/ApiReponseType"
import type { ProfileType } from "../types/ProfileType"
import { api } from "./api"

const ENDPOINT = '/user'

export const UserService = {

    

    getProfile: async():Promise<ApiResponseType<ProfileType>> => {
        const token = localStorage.getItem('token')
        if(!token){
            throw new Error('token not Found')
        }
        const response = await api.get<ApiResponseType<ProfileType>>(`${ENDPOINT}/me`,{
            headers:{Authorization:`Bearer ${token}`}
        })

        return response.data
    }
}