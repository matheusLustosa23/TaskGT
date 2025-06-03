package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.dto.request.UserCreateRequestDTO;
import com.matheuslustosa.user_registration.dto.response.UserCreateResponseDTO;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.enums.RoleType;
import com.matheuslustosa.user_registration.exceptions.ResourceAlreadyExistsException;
import com.matheuslustosa.user_registration.exceptions.UserNotFoundException;
import com.matheuslustosa.user_registration.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

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

    public UserCreateResponseDTO registerUser(UserCreateRequestDTO dto){


        if(userRepository.findByEmail(dto.email()).isPresent()){
            throw new ResourceAlreadyExistsException("Email already in use");
        }


        User user = new User();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRoles(Set.of(roleService.getOrThrow(RoleType.USER.name())));
        userRepository.save(user);




        return new UserCreateResponseDTO(dto.username(), dto.email());
    }

    public void deleteUser(UUID id){
       User user = userRepository.findById(id).orElseThrow(
               () -> new UserNotFoundException("User not found")
       );

        userRepository.delete(user);

    }
}
