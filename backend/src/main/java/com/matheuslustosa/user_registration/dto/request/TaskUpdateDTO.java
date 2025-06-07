package com.matheuslustosa.user_registration.dto.request;

import com.matheuslustosa.user_registration.enums.TaskPriority;
import com.matheuslustosa.user_registration.enums.TaskStatus;

import java.time.LocalDate;

public record TaskUpdateDTO(String title, String description, TaskStatus status,TaskPriority priority, LocalDate deadLine) {
}
