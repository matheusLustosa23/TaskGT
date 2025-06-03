package com.matheuslustosa.user_registration.controller;

import com.matheuslustosa.user_registration.dto.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.CreateTaskRequestDTO;
import com.matheuslustosa.user_registration.dto.CreateTaskResponseDTO;
import com.matheuslustosa.user_registration.dto.CreateUserResponseDTO;
import com.matheuslustosa.user_registration.entity.Task;
import com.matheuslustosa.user_registration.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public ResponseEntity<ApiResponseDTO<CreateTaskResponseDTO>>registerTask(@RequestBody CreateTaskRequestDTO dto){
        CreateTaskResponseDTO data=taskService.saveTask(dto);

        ApiResponseDTO<CreateTaskResponseDTO>response=ApiResponseBuilder.success(
                data,
                HttpStatus.CREATED.value(),
                "Task registered successfully",
                 "/task"


        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }




}
