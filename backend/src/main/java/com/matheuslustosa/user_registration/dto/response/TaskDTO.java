package com.matheuslustosa.user_registration.dto.response;

import com.matheuslustosa.user_registration.entity.Task;
import com.matheuslustosa.user_registration.enums.TaskPriority;
import com.matheuslustosa.user_registration.enums.TaskStatus;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public record TaskDTO(Long id, String title, String description, TaskStatus status, TaskPriority priority, LocalDate deadLine) {

    public TaskDTO(Task task){
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority(), task.getDeadLine());
    }
}
