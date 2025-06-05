package com.matheuslustosa.user_registration.repository;
import com.matheuslustosa.user_registration.entity.Task;
import com.matheuslustosa.user_registration.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task>findByUser(User user);
}
