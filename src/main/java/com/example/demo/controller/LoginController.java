package com.example.demo.controller;

import com.example.demo.CustomUserDetailsService;
import com.example.demo.JwtUtils;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.Login;
import com.example.demo.model.Users;
import com.example.demo.repository.IRoleRepository;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/auth")
public class LoginController {

    private IUserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private JwtUtils jwtUtils;
    private IRoleRepository roleRepository;

    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, IUserRepository userRepository,CustomUserDetailsService customUserDetailsService,
                          IRoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.customUserDetailsService=customUserDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody Login login) {
        UserDetails userDetails=customUserDetailsService.loadUserByUsername(login.getUsername());
        if(passwordEncoder.matches(login.getPassword(),userDetails.getPassword())){
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token=jwtUtils.generateAccessToken(authentication);
            return new ResponseEntity<>(new AuthResponse(token), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        }

    }


}
