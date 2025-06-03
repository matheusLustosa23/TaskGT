package com.matheuslustosa.user_registration.dto;

import com.matheuslustosa.user_registration.entity.Task;
import jakarta.annotation.Nonnull;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public record CreateTaskRequestDTO(UUID userId, String title, String description, Task.PriorityTask priority, LocalDate deadline) {
}
