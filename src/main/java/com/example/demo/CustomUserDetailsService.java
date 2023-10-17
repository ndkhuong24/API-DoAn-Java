package com.example.demo;

import com.example.demo.model.Roles;
import com.example.demo.model.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {
     private IUserRepository userRepository;
     @Autowired
     public CustomUserDetailsService(IUserRepository userRepository) {
         this.userRepository = userRepository;
     }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.getUsersByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        String password=user.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        // Lấy danh sách các vai trò và chuyển thành mảng chuỗi
        String[] roles = user.getRoles().stream()
                .map(role -> role.getName())
                .toArray(String[]::new);

        String rolesString = Arrays.toString(roles);
        System.out.println(rolesString+"jj");
        return User.withUsername(username).password(hashedPassword).roles(rolesString).build();
    }



}
