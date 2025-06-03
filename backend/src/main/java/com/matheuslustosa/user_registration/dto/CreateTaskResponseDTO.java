package com.matheuslustosa.user_registration.dto;

import com.matheuslustosa.user_registration.entity.Task;

import java.time.LocalDate;
import java.util.Date;

public record CreateTaskResponseDTO(String title, Task.StatusTask status, LocalDate deadLine){
}
