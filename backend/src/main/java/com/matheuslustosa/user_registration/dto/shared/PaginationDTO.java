package com.matheuslustosa.user_registration.dto.shared;

public record PaginationDTO(int page, int size, int totalElements, int totalPages, boolean hasNext, boolean hasPrevious) {
}
