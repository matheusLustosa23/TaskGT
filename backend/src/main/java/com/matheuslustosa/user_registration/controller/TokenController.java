package com.matheuslustosa.user_registration.controller;


import com.matheuslustosa.user_registration.dto.ApiResponseDTO;
import com.matheuslustosa.user_registration.dto.LoginRequestDTO;
import com.matheuslustosa.user_registration.dto.LoginResponseDTO;
import com.matheuslustosa.user_registration.dto.SummaryDTO;
import com.matheuslustosa.user_registration.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping("/login")
public class TokenController {
    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<LoginResponseDTO>>login(@RequestBody LoginRequestDTO dto){

        var data = tokenService.login(dto);
        ApiResponseDTO<LoginResponseDTO>response=ApiResponseBuilder.success(data,"Users fetched successfully","/login");
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }
}
