package com.matheuslustosa.user_registration.dto.request;

import com.matheuslustosa.user_registration.enums.TaskPriority;

import java.time.LocalDate;
import java.util.UUID;

public record TaskCreateRequestDTO(UUID userId, String title, String description, TaskPriority priority, LocalDate deadline) {
}
