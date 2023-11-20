package com.example.demo.controller;

import com.example.demo.dto.Login;
import com.example.demo.dto.MessageResponse;
import com.example.demo.dto.UserInfoResponse;
import com.example.demo.repository.IUserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.service.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class LoginController {
@Autowired
    AuthenticationManager authenticationManager;
@Autowired
    IUserRepository userRepository;
//@Autowired
//    PasswordEncoder encoder;
@Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser( @RequestBody Login login) {
       // String encodedPassword = encoder.encode(login.getPassword());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();

       // ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        System.out.println(userDetails.getUsername());
        System.out.println(roles);
        String token=jwtUtils.generateTokenFromUsername(userDetails.getUsername());
        UserInfoResponse userInfoResponse=new UserInfoResponse(userDetails.getId(),userDetails.getUsername(),userDetails.getEmail(),userDetails.getFullname(),roles,token);
//        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//                .body(new UserInfoResponse(userDetails.getId(),
//                        userDetails.getUsername(),
//                        userDetails.getEmail(),
//                        roles,token));
        return ResponseEntity.ok(userInfoResponse);

    }
    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}
