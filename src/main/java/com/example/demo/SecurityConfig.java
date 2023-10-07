package com.example.demo;
import com.example.demo.model.Users;
import com.example.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Lazy
    @Autowired
    BCryptPasswordEncoder pe;
    /* Cung cấp nguồn dữ liệu đăng nhập */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try {
                Users user = userService.getByUsername(username);    /* Tải user từ db */
                String password = pe.encode(user.getPassword());    /* Mã hóa password */
                String[] roles = user.getAuthorities().stream()    /* Lấy các vai trò của người dùng -> đổi thành mảng */
                        .map(er -> er.getRole().getName()).toList().toArray(new String[0]); /* Đổi thành mảng */
                return User.withUsername(username).password(password).roles(roles).build();
            } catch (NoSuchElementException e) { /* User không tồn tại ngoại lệ */
                throw new UsernameNotFoundException(username + "Không tìm thấy !");
            }
        });
    }
    /* Phân quyền */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/Customer").permitAll() // Cho phép tất cả mọi người truy cập vào địa chỉ này
               .antMatchers("/api/User/**").hasRole("admin") // Yêu cầu có quyền ADMIN để truy cập các địa chỉ này
                .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                .and()
                .formLogin() // Cho phép người dùng xác thực bằng form login
                //.defaultSuccessUrl("/api/User/")
                .permitAll() // Tất cả đều được truy cập vào địa chỉ này
                .and()
                .logout() // Cho phép logout
                .permitAll();
    }
    /* Cơ chế mã hóa mật khẩu */
    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /* Cho phép truy xuất REST API từ bên ngoài (domain khác ) */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }
}
