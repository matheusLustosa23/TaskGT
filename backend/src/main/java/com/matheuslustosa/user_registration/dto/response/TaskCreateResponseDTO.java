package com.matheuslustosa.user_registration.dto.response;

import com.matheuslustosa.user_registration.enums.TaskStatus;

import java.time.LocalDate;

public record TaskCreateResponseDTO(String title, TaskStatus status, LocalDate deadLine){
}
