package com.matheuslustosa.user_registration.controller;

import com.matheuslustosa.user_registration.controller.response.ApiSuccessBuilder;
import com.matheuslustosa.user_registration.dto.shared.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.request.UserCreateRequestDTO;
import com.matheuslustosa.user_registration.dto.response.UserCreateResponseDTO;
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
    public ResponseEntity<ApiResponseDTO<UserCreateResponseDTO>>createUser(@RequestBody UserCreateRequestDTO dto){
       UserCreateResponseDTO data =  userService.registerUser(dto);
       ApiResponseDTO<UserCreateResponseDTO>response = ApiSuccessBuilder.success(
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
        ApiResponseDTO<Void>response = ApiSuccessBuilder.success(

                HttpStatus.OK.value(),
                "User deleted successfully",
                "/user"

        );

        return ResponseEntity.ok(response);


    }
}
