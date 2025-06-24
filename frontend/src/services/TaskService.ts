import type { ApiResponseType } from "../types/ApiReponseType"
import type { PaginationResponseType } from "../types/PaginationResponseType"
import type { PaginationRequestType } from "../types/PaginationResquestType"
import type { RegisterTaskRequestType} from "../types/RegisterTaskRequestType"
import type { RegisterTaskResponseType } from "../types/RegisterTaskResponseType"
import type { TaskType } from "../types/TaskType"
import { api } from "./api"


export const TaskService = {
    
    getById:async(id:number):Promise<ApiResponseType<TaskType>> => {
        const token = localStorage.getItem('token')
        if(!token){
            throw('token not found')
        }
        const response = await api.get<ApiResponseType<TaskType>>(`/task/${id}`,{

            headers:{Authorization:`Bearer ${token}`}
        })

        return response.data;

    },


    getAll: async(pagination:PaginationRequestType):Promise<ApiResponseType<PaginationResponseType<TaskType[]>>> => {
        const token = localStorage.getItem('token')
        if(!token){
            throw new Error('token not found')
        }
        const response = await api.get<ApiResponseType<PaginationResponseType<TaskType[]>>>('/task',{
            headers:{
                Authorization:`Bearer ${token}` 
            },
            params:{
                page:pagination.page,
                pageSize:pagination.pageSize
            }
           
            
       })
        return response.data
    },

    registerTask: async(data:RegisterTaskRequestType):Promise<ApiResponseType<RegisterTaskResponseType>> => {
        const token = localStorage.getItem('token')
        if(!token){
            throw new Error('token not found')
        }
        const response = await api.post<ApiResponseType<RegisterTaskResponseType>>('/task',data,{
            headers:{
                Authorization:`Bearer ${token}`
            }

        })

        return response.data
    }
    // updateTask:string,
    // deleteById:string
}