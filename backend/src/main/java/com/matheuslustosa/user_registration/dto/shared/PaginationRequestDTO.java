package com.matheuslustosa.user_registration.dto.shared;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import static com.matheuslustosa.user_registration.util.PaginationConstants.*;

public record PaginationRequestDTO(
        @Min(value = PAGE_DEFAULT,message = "O valor precis ser no minimo:"+PAGE_DEFAULT)
        int page,
        @Min(value = MIN_SIZE, message = "O valor precisa ser no minimo:"+MIN_SIZE)
        @Max(value = MAX_SIZE,message = "O valor maximo e:"+MAX_SIZE)
        int pageSize
)
{ }
