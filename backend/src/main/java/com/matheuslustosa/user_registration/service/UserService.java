package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.controller.handler.ErroCodesApi;
import com.matheuslustosa.user_registration.dto.request.UserCreateRequestDTO;
import com.matheuslustosa.user_registration.dto.response.ProfileDTO;
import com.matheuslustosa.user_registration.dto.response.UserCreateResponseDTO;
import com.matheuslustosa.user_registration.entity.Role;
import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.enums.RoleType;
import com.matheuslustosa.user_registration.exceptions.ResourceAlreadyExistsException;
import com.matheuslustosa.user_registration.exceptions.UserNotFoundException;
import com.matheuslustosa.user_registration.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private  final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, RoleService roleService, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public ProfileDTO getProfile(){
        UUID authId = jwtService.getUserId();
        User user = userRepository.findById(authId).orElseThrow(
                () -> new UserNotFoundException("User not found")
        );

        Set<String>roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());

         return  new ProfileDTO(
                 user.getId(),
                 user.getUsername(),
                 user.getEmail(),
                 roles
         );
    }

    public UserCreateResponseDTO registerUser(UserCreateRequestDTO dto){


        if(userRepository.findByEmail(dto.email()).isPresent()){
            throw new ResourceAlreadyExistsException("The email "+dto.email()+" already exists");
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
