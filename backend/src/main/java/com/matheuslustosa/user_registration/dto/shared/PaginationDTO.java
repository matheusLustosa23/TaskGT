package com.matheuslustosa.user_registration.dto.shared;

import com.matheuslustosa.user_registration.dto.response.TaskDTO;
import org.springframework.data.domain.Page;


public record PaginationDTO(long page, long size, long totalElements, long totalPages, boolean hasNext, boolean hasPrevious) {
    public PaginationDTO(Page<?> pageable){
        this(  pageable.getNumber(),
                pageable.getSize(),
                pageable.getTotalElements(),
                pageable.getTotalPages(),
                pageable.hasNext(),
                pageable.hasPrevious() );
    }
}
