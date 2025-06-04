package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.controller.handler.ErroCodesApi;
import com.matheuslustosa.user_registration.dto.request.TaskCreateRequestDTO;
import com.matheuslustosa.user_registration.dto.response.TaskCreateResponseDTO;
import com.matheuslustosa.user_registration.entity.Task;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.enums.RoleType;
import com.matheuslustosa.user_registration.enums.TaskStatus;
import com.matheuslustosa.user_registration.exceptions.InvalidCredentialsException;
import com.matheuslustosa.user_registration.exceptions.TaskNotFoundException;
import com.matheuslustosa.user_registration.exceptions.UserNotFoundException;
import com.matheuslustosa.user_registration.repository.TaskRepository;
import com.matheuslustosa.user_registration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private  final  JwtService jwtService;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, JwtService jwtService) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public TaskCreateResponseDTO saveTask(TaskCreateRequestDTO dto){

        UUID authId = jwtService.getUserId();

        User user=userRepository.findById(authId).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );

        Task task=new Task();
        task.setUser(user);
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(TaskStatus.TO_DO);
        task.setPriority(dto.priority());
        task.setDateLine(dto.deadline());

        taskRepository.save(task);

        return new TaskCreateResponseDTO(task.getTitle(),task.getStatus(),task.getDateLine())
;



    }

    public void deleteTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException("Task not found")
        );

        UUID authUserId = jwtService.getUserId();

        User userAuth = userRepository.findById(authUserId).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );

        boolean isAdmin = userAuth.getRoles().stream().anyMatch( role -> role.getName().equals(RoleType.ADMIN.name()));


        if (!authUserId.equals(task.getUser().getId()) && !isAdmin){
            throw new InvalidCredentialsException(ErroCodesApi.ACCESS_DENIED.getMessage());
        }


        taskRepository.delete(task);

    }


}



