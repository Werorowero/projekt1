package com.uken.project.controller;


import com.uken.project.controller.responses.AuthenticationRequest;
import com.uken.project.controller.responses.AuthenticationResponse;
import com.uken.project.controller.responses.RegisterRequest;
import com.uken.project.model.SchoolUser;
import com.uken.project.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//controller z endpointami do logowania/rejestrowania użytkowników
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    //rejestracja
    @PostMapping("/register/student")
    public ResponseEntity<AuthenticationResponse> registerStudent(
            @RequestBody RegisterRequest request
    ) {
        System.out.println("zarejestrowano studenta");
        return ResponseEntity.ok(authenticationService.registerStudent(request));
    }
    //rejestracja nauczyciela
    @PostMapping("/register/teacher")
    public ResponseEntity<AuthenticationResponse> registerTeacher(
            @RequestBody RegisterRequest request
    ) {
        System.out.println("zarejestrowano użytkownika(nauczyciel)");
        return ResponseEntity.ok(authenticationService.registerTeacher(request));
    }
    //logowanie
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println("Zalogowano użytkownika");
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
