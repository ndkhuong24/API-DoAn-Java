package com.example.demo;
import com.example.demo.model.Customer;
import com.example.demo.model.Roles;
import com.example.demo.model.Users;
import com.example.demo.service.customer.CustomerService;
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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.NoSuchElementException;
import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;
    @Lazy
    @Autowired
    BCryptPasswordEncoder pe;
    /* Cung cấp nguồn dữ liệu đăng nhập */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService())
                .passwordEncoder(getPasswordEncoder());
    }
    public UserDetailsService customUserDetailsService() {
        return username -> {
            Users user = userService.getByUsername(username);
            if (user != null) {
                String password = pe.encode(user.getPassword());
                String role = getRolesForUser(user); // Lấy vai trò cho user
                return User.withUsername(username).password(password).roles(role).build();
            } else {
                // Kiểm tra nếu là khách hàng
                Customer customer = customerService.getByUsername(username);
                if (customer != null) {
                    String password = pe.encode(customer.getPassword());
                    String role = getRolesForCustomer(customer); // Lấy vai trò cho customer
                    return User.withUsername(username).password(password).roles(role).build();
                } else {
                    throw new UsernameNotFoundException(username + "Không tìm thấy !");
                }
            }
        };
    }
    // Phương thức để lấy vai trò cho user
    private String getRolesForUser(Users user) {
        return user.getRole_id().getName();
    }

    // Phương thức để lấy vai trò cho customer
    private String getRolesForCustomer(Customer customer) {
        return customer.getRole_id().getName();
    }
    /* Phân quyền */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/").permitAll() // Cho phép tất cả mọi người truy cập vào địa chỉ này
                .antMatchers("/api/User/**").hasRole("admin") // Yêu cầu có quyền ADMIN để truy cập các địa chỉ này
                .antMatchers("/api/Customer/**").hasRole("customer")
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
