package com.matheuslustosa.user_registration.config;

import com.matheuslustosa.user_registration.entity.Role;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.enums.RoleType;
import com.matheuslustosa.user_registration.exceptions.UserNotFoundException;
import com.matheuslustosa.user_registration.repository.UserRepository;
import com.matheuslustosa.user_registration.service.DevTaskSeederService;
import com.matheuslustosa.user_registration.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Configuration
@Profile("test")
public class DevTaskSeeder implements CommandLineRunner {




    @Value("${default.user.password}")
    private String userDefaultPassword;

    private final RoleService roleService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final DevTaskSeederService devTaskSeederService;


    public DevTaskSeeder(RoleService roleService, UserRepository userRepository, PasswordEncoder passwordEncoder, DevTaskSeederService devTaskSeederService) {

        this.roleService = roleService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.devTaskSeederService = devTaskSeederService;
    }

    @Override
    @Transactional
    @Order(2)
    public void run(String... args) throws Exception {



        var userUser = userRepository.findByUsername("user");
        userUser.ifPresentOrElse(
                user -> {
                    System.out.println("User user ja existe!");
                },
                () -> {
                    Role roleUser=roleService.getOrThrow(RoleType.USER.name());
                    System.out.println("Criando User user");
                    User user = new User();
                    user.setUsername("user");
                    user.setPassword(
                            passwordEncoder.encode(userDefaultPassword)
                    );

                    user.setRoles(Set.of(roleUser));
                    userRepository.save(user);
                    System.out.println("User  user criado com sucesso!");
                }
        );

        User admin = userRepository.findByUsername("admin").orElseThrow(
                () -> new UserNotFoundException("user admin not found")
        );
        User user = userRepository.findByUsername("user").orElseThrow(
                () -> new UserNotFoundException("user user not found")
        );

        devTaskSeederService.addTask(0,99,admin);
        devTaskSeederService.addTask(100,199,user);






    }
}
