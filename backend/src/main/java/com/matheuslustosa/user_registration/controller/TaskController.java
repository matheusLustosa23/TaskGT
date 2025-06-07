package com.matheuslustosa.user_registration.controller;
import com.matheuslustosa.user_registration.controller.response.ApiSuccessBuilder;
import com.matheuslustosa.user_registration.dto.request.TaskUpdateDTO;
import com.matheuslustosa.user_registration.dto.response.TaskDTO;
import com.matheuslustosa.user_registration.dto.shared.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.request.TaskCreateRequestDTO;
import com.matheuslustosa.user_registration.dto.response.TaskCreateResponseDTO;
import com.matheuslustosa.user_registration.dto.shared.PaginationReponseDTO;
import com.matheuslustosa.user_registration.dto.shared.PaginationRequestDTO;
import com.matheuslustosa.user_registration.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<Void>>deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        ApiResponseDTO<Void>response = ApiSuccessBuilder.success(
                HttpStatus.OK.value(),
                 "Task deleted successfully",
                "/task/"+id
        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<TaskDTO>>updateTaskById(@PathVariable Long id, @RequestBody TaskUpdateDTO dto){
        TaskDTO data = taskService.updateTaskById(id, dto);
        ApiResponseDTO<TaskDTO>response = ApiSuccessBuilder.success(
                data,
                HttpStatus.OK.value(),
                "Task update successfully",
                "/task/"+id
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<TaskDTO>>getTaskById(@PathVariable Long  id){
        TaskDTO data=taskService.getTaskById(id);
        ApiResponseDTO<TaskDTO>response = ApiSuccessBuilder.success(
                data,
                HttpStatus.OK.value(),
                "Operation successfully",
                "/task/"+id

        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity
            <ApiResponseDTO<PaginationReponseDTO<TaskDTO>>>getAllTaskByUser(@Valid @ModelAttribute PaginationRequestDTO pagination){


        Page<TaskDTO> taskPage = taskService.getAllTasksByUSer(pagination.page(), pagination.pageSize());


        ApiResponseDTO<PaginationReponseDTO<TaskDTO>>response= ApiSuccessBuilder.success(
                taskPage,
                HttpStatus.OK.value(),
                "Request successfully",
                "/task"

        );

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }








}
