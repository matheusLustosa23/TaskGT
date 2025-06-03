package com.matheuslustosa.user_registration.entity;

import com.matheuslustosa.user_registration.enums.TaskPriority;
import com.matheuslustosa.user_registration.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;


@Entity
@Table(name = "tb_task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    private LocalDate dateLine;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task(Long id, String title, String description, TaskStatus status, TaskPriority priority, LocalDate dateLine, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.dateLine = dateLine;
        this.user = user;
    }

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDate getDateLine() {
        return dateLine;
    }

    public void setDateLine(LocalDate dateLine) {
        this.dateLine = dateLine;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }





}
