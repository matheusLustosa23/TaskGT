package com.matheuslustosa.user_registration.controller;

import com.matheuslustosa.user_registration.dto.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.CreateUserRequestDTO;
import com.matheuslustosa.user_registration.dto.CreateUserResponseDTO;
import com.matheuslustosa.user_registration.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<CreateUserResponseDTO>>createUser(@RequestBody CreateUserRequestDTO dto){
       CreateUserResponseDTO data =  userService.registerUser(dto);
       ApiResponseDTO<CreateUserResponseDTO>response = ApiResponseBuilder.success(
               data,
               HttpStatus.CREATED.value(),
               "User registered successfully",
               "/user"


       );

       return ResponseEntity.status(HttpStatus.CREATED).body(response);


    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    ResponseEntity<ApiResponseDTO<Void>>deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
        ApiResponseDTO<Void>response = ApiResponseBuilder.success(
                null,
                HttpStatus.OK.value(),
                "User deleted successfully",
                "/user"

        );

        return ResponseEntity.ok(response);


    }
}
