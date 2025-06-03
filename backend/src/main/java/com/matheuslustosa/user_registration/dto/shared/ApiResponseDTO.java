package com.matheuslustosa.user_registration.dto.shared;

public record ApiResponseDTO<T>(SummaryDTO summary , T data, PaginationDTO pagination) {
}
