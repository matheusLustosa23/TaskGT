package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.dto.CreateTaskRequestDTO;
import com.matheuslustosa.user_registration.dto.CreateTaskResponseDTO;
import com.matheuslustosa.user_registration.dto.CreateUserResponseDTO;
import com.matheuslustosa.user_registration.entity.Task;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.exceptions.TaskNotFoundException;
import com.matheuslustosa.user_registration.exceptions.UserNotFoundException;
import com.matheuslustosa.user_registration.repository.TaskRepository;
import com.matheuslustosa.user_registration.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public CreateTaskResponseDTO saveTask(CreateTaskRequestDTO dto){
        User user=userRepository.findById(dto.userId()).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );

        Task task=new Task();
        task.setUser(user);
        task.setTitle(dto.title());
        task.setDescription(dto.description());
        task.setStatus(Task.StatusTask.TO_DO);
        task.setPriority(dto.priority());
        task.setDateLine(dto.deadline());

        taskRepository.save(task);

        return new CreateTaskResponseDTO(task.getTitle(),task.getStatus(),task.getDateLine())
;



    }


}
