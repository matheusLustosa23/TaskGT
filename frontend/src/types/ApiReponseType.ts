import type { SummaryResponseType } from "./SummaryResponseType"

export type ApiResponseType<T>= {
    summary:SummaryResponseType,
    data: T | null
}