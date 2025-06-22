package com.matheuslustosa.user_registration.dto.response;



import java.util.List;

import java.util.Set;
import java.util.UUID;

public record ProfileDTO(UUID id, String username, String email, Set<String> roles) {
}
