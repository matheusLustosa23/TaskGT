package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class DevTaskSeederService {

    private JdbcTemplate jdbcTemplate;

    public DevTaskSeederService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addTask(int start, int end, User user){

        int total = end - start+1;
        UUID userID = user.getId();

        for(int i = start; i<=end ;i++){

            String title = "task"+i;
            String description = "task test n:"+i;
            String priority = switch (i % 4){
                case 0 -> "LOW";
                case 1 -> "MEDIUM";
                case 2 -> "HIGH";
                default -> "CRITICAL";

            };
            String status = switch (i%6){
                case 0 -> "COMPLETED";
                case 1 -> "IN_PROGRESS";
                case 2 -> "PAUSED";
                case 3 -> "CANCELED";
                case 4 -> "OVERDUE";
                default -> "TO_DO";
            };

            LocalDate deadLine = LocalDate.now().plusDays(i);

            jdbcTemplate.update("""
            INSERT INTO tb_task (title, description, status, priority,dead_line,user_id)
            VALUES (?,?,?,?,?,?)
""",title,description,status,priority, Date.valueOf(deadLine),userID);







        }

        System.out.println(total+" tasks added successfully to user:"+user.getUsername());



    }

}
