package com.bezkoder.spring.security.postgresql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.security.postgresql.dto.JwtResponse;
import com.bezkoder.spring.security.postgresql.dto.LoginRequest;
import com.bezkoder.spring.security.postgresql.dto.SignupRequest;
import com.bezkoder.spring.security.postgresql.models.User;

import com.bezkoder.spring.security.postgresql.repository.UserRepository;
import com.bezkoder.spring.security.postgresql.security.jwt.JwtUtils;
import com.bezkoder.spring.security.postgresql.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired UserRepository userRepo;
  @Autowired PasswordEncoder encoder;
  @Autowired AuthenticationManager authManager;
  @Autowired JwtUtils jwtUtils;

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody SignupRequest req) {
    if (userRepo.existsByUsername(req.getUsername())) {
      return ResponseEntity.badRequest().body("User Name Already Exists!!!");
    }
    if (userRepo.existsByUsername(req.getEmail())) {
        return ResponseEntity.badRequest().body("Email Already Exists!!!");
      }
    User user = new User();
    user.setUsername(req.getUsername());
    user.setEmail(req.getEmail());
    user.setPassword(encoder.encode(req.getPassword()));
    userRepo.save(user);
    return ResponseEntity.ok("User Registered Successfully!!!");
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest req) {
    Authentication auth = authManager.authenticate(
        new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(auth);
    String jwt = jwtUtils.generateJwtToken(auth);
    UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getEmail()));
  }
}
