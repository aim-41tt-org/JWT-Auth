package ru.example.JWT_Auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.example.JWT_Auth.DTO.request.AuthenticationRequest;
import ru.example.JWT_Auth.DTO.request.RegisterRequest;
import ru.example.JWT_Auth.DTO.response.AuthenticationResponse;
import ru.example.JWT_Auth.service.AuthenticationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	private final AuthenticationService authService;

	public AuthController(AuthenticationService authService) {
		this.authService = authService;
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
		AuthenticationResponse authenticationResponse = null;
		try {
			authenticationResponse = authService.register(request);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(e.getMessage());
		}
		return ResponseEntity.ok(authenticationResponse);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
		try {
			return ResponseEntity.ok(authService.authenticate(request));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(e.getMessage());
		}
	}

}
