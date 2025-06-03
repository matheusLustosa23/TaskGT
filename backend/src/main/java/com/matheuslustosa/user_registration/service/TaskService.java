package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.dto.request.TaskCreateRequestDTO;
import com.matheuslustosa.user_registration.dto.response.TaskCreateResponseDTO;
import com.matheuslustosa.user_registration.entity.Task;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.enums.TaskStatus;
import com.matheuslustosa.user_registration.exceptions.UserNotFoundException;
import com.matheuslustosa.user_registration.repository.TaskRepository;
import com.matheuslustosa.user_registration.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskCreateResponseDTO saveTask(TaskCreateRequestDTO dto){
        User user=userRepository.findById(dto.userId()).orElseThrow(
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


}
