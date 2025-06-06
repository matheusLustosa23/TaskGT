package com.matheuslustosa.user_registration.dto.shared;

import java.util.List;

public record PaginationReponseDTO<T>(List<T> data , PaginationDTO paginationDTO) {
}
