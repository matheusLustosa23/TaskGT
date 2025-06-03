package com.matheuslustosa.user_registration.controller;


import com.matheuslustosa.user_registration.controller.response.ApiSuccessBuilder;
import com.matheuslustosa.user_registration.dto.shared.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.request.LoginRequestDTO;
import com.matheuslustosa.user_registration.dto.response.LoginResponseDTO;
import com.matheuslustosa.user_registration.service.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AuthController {
    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<LoginResponseDTO>>login(@RequestBody LoginRequestDTO dto){

        var data = jwtService.login(dto);
        ApiResponseDTO<LoginResponseDTO>response= ApiSuccessBuilder.success(data,HttpStatus.OK.value(), "Users fetched successfully","/login");
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }
}
