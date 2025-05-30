package com.matheuslustosa.user_registration.repository;

import com.matheuslustosa.user_registration.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
