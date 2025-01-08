package com.uken.project.controller;


import com.uken.project.controller.responses.AuthenticationRequest;
import com.uken.project.controller.responses.AuthenticationResponse;
import com.uken.project.controller.responses.RegisterRequest;
import com.uken.project.model.SchoolUser;
import com.uken.project.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register/student")
    public ResponseEntity<AuthenticationResponse> registerStudent(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.registerStudent(request));
    }

    @PostMapping("/register/teacher")
    public ResponseEntity<AuthenticationResponse> registerTeacher(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.registerTeacher(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println("TEST");
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
