package com.matheuslustosa.user_registration.dto;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public record ApiResponseDTO<T>(SummaryDTO summary , T data, PaginationResponseDTO pagination) {
}
