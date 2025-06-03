package com.matheuslustosa.user_registration.controller;

import com.matheuslustosa.user_registration.controller.response.ApiSuccessBuilder;
import com.matheuslustosa.user_registration.dto.shared.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.request.TaskCreateRequestDTO;
import com.matheuslustosa.user_registration.dto.response.TaskCreateResponseDTO;
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
    public ResponseEntity<ApiResponseDTO<TaskCreateResponseDTO>>registerTask(@RequestBody TaskCreateRequestDTO dto){
        TaskCreateResponseDTO data=taskService.saveTask(dto);

        ApiResponseDTO<TaskCreateResponseDTO>response= ApiSuccessBuilder.success(
                data,
                HttpStatus.CREATED.value(),
                "Task registered successfully",
                 "/task"


        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }




}
