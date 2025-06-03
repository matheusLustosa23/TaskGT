package com.matheuslustosa.user_registration.service;

import com.matheuslustosa.user_registration.dto.response.LoginResponseDTO;
import com.matheuslustosa.user_registration.dto.request.LoginRequestDTO;
import com.matheuslustosa.user_registration.entity.Role;

import com.matheuslustosa.user_registration.entity.User;
import com.matheuslustosa.user_registration.exceptions.InvalidCredentialsException;
import com.matheuslustosa.user_registration.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {

    private final JwtEncoder jwtEncoder;
    private final  UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    

    public JwtService(JwtEncoder jwtEncoder, UserRepository userRepository, PasswordEncoder passwordEncoder) {

        this.jwtEncoder = jwtEncoder;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO login(LoginRequestDTO dto){


        Instant now = Instant.now();
        long expiresIn = 3600L;

        User user = userRepository.findByUsername(dto.username()).orElseThrow(
                ()-> new InvalidCredentialsException("user or password is invalid")
        );

        boolean isLoginCorrect=passwordEncoder.matches(dto.password(),user.getPassword());
        if(!isLoginCorrect){
            throw new InvalidCredentialsException("user or password is invalid");
        }



        String scopes = user.getRoles().stream()
                .map(Role::getName).collect(Collectors.joining(" "));



        JwtClaimsSet  claims = JwtClaimsSet.builder()
                .issuer("TaskGT")
                .subject(user.getUsername())
                .claim("scope",scopes)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn)).build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponseDTO(token,expiresIn);


    }



}
