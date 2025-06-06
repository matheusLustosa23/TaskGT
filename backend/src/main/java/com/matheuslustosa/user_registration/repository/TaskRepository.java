package com.matheuslustosa.user_registration.repository;
import com.matheuslustosa.user_registration.entity.Task;
import com.matheuslustosa.user_registration.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    Page<Task>findByUser(User user, Pageable pageable);
}
