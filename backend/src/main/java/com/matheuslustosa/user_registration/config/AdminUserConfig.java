package com.matheuslustosa.user_registration.config;

import com.matheuslustosa.user_registration.entity.Role;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.repository.RoleRepository;
import com.matheuslustosa.user_registration.repository.UserRepository;
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

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public AdminUserConfig(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {



        var roleAdmin = roleRepository.findByName(Role.typeRole.ADMIN.name());


        roleAdmin.ifPresentOrElse(
                role ->{
                    System.out.println("Role admin ja existe!");
                },
                ()->{
                    System.out.println("Criando Role admin");
                    Role role = new Role();
                    role.setName(Role.typeRole.ADMIN.name());
                    roleRepository.save(role);
                    System.out.println("Role admin criada com sucesso!");
                }
        );

        var roleUser = roleRepository.findByName(Role.typeRole.USER.name());

        roleUser.ifPresentOrElse(
                role -> {
                    System.out.println("Role user ja existe!");
                },
                () -> {
                    System.out.println("Criando Role user");
                    Role role = new Role();
                    role.setName(Role.typeRole.USER.name());
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
                    user.setRoles(Set.of(
                            roleRepository.findByName(Role.typeRole.ADMIN.name())
                                    .orElseThrow(()->
                                            new IllegalStateException("Não foi possivel atribuir a role admin ao user , role não encontrada"))
                    ));
                    userRepository.save(user);
                    System.out.println("User admin criado com sucesso!");
                }
        );



    }





}
