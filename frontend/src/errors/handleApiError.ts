import { AxiosError } from "axios";

export function handleApiError(error: unknown, defaultMessage: string): string {
    if (error instanceof AxiosError) {
        const apiError = error.response?.data;
        if (apiError?.summary?.message) {
            return apiError.summary.message;
        }
        return error.message;
    }
    if (error instanceof Error) {
        return error.message;
    }
    return defaultMessage;
}
