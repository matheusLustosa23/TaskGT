package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.dto.CreateUserRequestDTO;
import com.matheuslustosa.user_registration.dto.CreateUserResponseDTO;
import com.matheuslustosa.user_registration.entity.Role;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.exceptions.ResourceAlreadyExists;
import com.matheuslustosa.user_registration.exceptions.RoleNotFound;
import com.matheuslustosa.user_registration.repository.RoleRepository;
import com.matheuslustosa.user_registration.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private  final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    public CreateUserResponseDTO registerUser(CreateUserRequestDTO dto){


        if(userRepository.findByEmail(dto.email()).isPresent()){
            throw new ResourceAlreadyExists("Email already in use");
        }


        User user = new User();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRoles(Set.of(roleService.getOrThrow(Role.typeRole.USER.name())));
        userRepository.save(user);




        return new CreateUserResponseDTO(dto.username(), dto.email());
    }
}
