package com.matheuslustosa.user_registration.config;

import com.matheuslustosa.user_registration.entity.Role;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.enums.RoleType;
import com.matheuslustosa.user_registration.repository.RoleRepository;
import com.matheuslustosa.user_registration.repository.UserRepository;
import com.matheuslustosa.user_registration.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    @Value("${default.admin.password}")
    private String adminDefaultPassword;
    private final RoleService roleService;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminUserConfig(RoleService roleService, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {



        var roleAdmin = roleRepository.findByName(RoleType.ADMIN.name());


        roleAdmin.ifPresentOrElse(
                role ->{
                    System.out.println("Role admin ja existe!");
                },
                ()->{
                    System.out.println("Criando Role admin");
                    Role role = new Role();
                    role.setName(RoleType.ADMIN.name());
                    roleRepository.save(role);
                    System.out.println("Role admin criada com sucesso!");
                }
        );

        var roleUser = roleRepository.findByName(RoleType.USER.name());

        roleUser.ifPresentOrElse(
                role -> {
                    System.out.println("Role user ja existe!");
                },
                () -> {
                    System.out.println("Criando Role user");
                    Role role = new Role();
                    role.setName(RoleType.USER.name());
                    roleRepository.save(role);
                    System.out.println("Role user criada com sucesso!");
                }
        );


        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("User admin ja existe!");
                },
                () -> {
                    System.out.println("Criando User admin");
                    User user= new User();
                    user.setUsername("admin");
                    user.setPassword(
                            passwordEncoder.encode(adminDefaultPassword)
                    );
                    user.setRoles(Set.of(roleService.getOrThrow(RoleType.ADMIN.name())));
                    userRepository.save(user);
                    System.out.println("User admin criado com sucesso!");
                }
        );



    }





}
