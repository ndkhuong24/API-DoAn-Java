package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.Authority;
import com.example.demo.model.Users;
import com.example.demo.repository.IAuthorityRepository;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.service.UserDetailImpl;
import com.example.demo.service.user.ForgotPassWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IRoleRepository roleRepository;
    @Autowired
    ForgotPassWordService forgotPassWordService;
    @Autowired
    IAuthorityRepository authorityRepository;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Login login) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        String token = jwtUtils.generateTokenFromUsername(userDetails.getUsername());
        UserInfoResponse userInfoResponse = new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), userDetails.getFullname(), roles, token);
        return ResponseEntity.ok(userInfoResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
    @PostMapping("/singup")
    public ResponseEntity<?> registerUser( @Valid @RequestBody SingupRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        Users users= new Users(signUpRequest.getFullname(),signUpRequest.getEmail(), signUpRequest.getPhone(), signUpRequest.getUsername(),signUpRequest.getPassword());
        userRepository.save(users);
        Authority authority=new Authority(users.getId(), 6);
        authorityRepository.save(authority);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPass(@RequestBody Users users){
        String response = forgotPassWordService.forgotPass(users.getEmail());

//        if(!response.startsWith("Invalid")){
//            response= "http://localhost:8081/api/auth/reset-password?token=" + response;
//        }
//        return response;
        return ResponseEntity.ok(response);
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPass(@RequestBody Users users) {
       return  new ResponseEntity<>(forgotPassWordService.resetPass(users.getEmail(), users.getPassword()), HttpStatus.OK);
    }
}
