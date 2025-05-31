package com.matheuslustosa.user_registration.dto;

public record PaginationResponseDTO(int page,int size,int totalElements,int totalPages,boolean hasNext,boolean hasPrevious) {
}
