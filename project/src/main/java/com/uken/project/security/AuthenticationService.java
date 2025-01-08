package com.uken.project.security;

import com.uken.project.controller.responses.AuthenticationRequest;
import com.uken.project.controller.responses.AuthenticationResponse;
import com.uken.project.controller.responses.RegisterRequest;
import com.uken.project.model.Role;
import com.uken.project.model.SchoolUser;
import com.uken.project.repository.StudentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final StudentsRepository studentsRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse registerStudent(RegisterRequest request) {
        var user = SchoolUser.builder()
                .email(request.getEmail())
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.STUDENT)
                .build();
        studentsRepository.save(user);
        var jwtToken = jwtService.generateToken(user, user.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }

    public AuthenticationResponse registerTeacher(RegisterRequest request) {
        var user = SchoolUser.builder()
                .email(request.getEmail())
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.TEACHER)
                .build();
        studentsRepository.save(user);
        var jwtToken = jwtService.generateToken(user, user.getId());
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = studentsRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user, user.getId());
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
