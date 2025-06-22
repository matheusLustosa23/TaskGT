import type { PaginationType } from "./PaginationType"

export type PaginationResponseType<T>= {
    items:T,
    pagination:PaginationType


}