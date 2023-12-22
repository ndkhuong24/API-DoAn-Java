package com.example.demo.security;

import com.example.demo.security.jwt.AuthEntryPoinJwt;
import com.example.demo.security.jwt.AuthTokenFilter;
import com.example.demo.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthEntryPoinJwt authEntryPoinJwt;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authEntryPoinJwt).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/filter").permitAll()
                .antMatchers("/search/**").permitAll()
                .antMatchers("/api/Color/getAll/active").permitAll()
                .antMatchers("/api/Material/getAll/active").permitAll()
                .antMatchers("/api/Size/getAll/active").permitAll()
                .antMatchers("/api/Sole/getAll/active").permitAll()
                .antMatchers("/api/Category/getAll/active").permitAll()
                .antMatchers("/api/Brand/getAll/active").permitAll()
                .antMatchers("/api/Voucher/id/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/api/Product2/getAll").permitAll()
                .antMatchers("/reset-password/**").permitAll()
                .antMatchers("/bieudo/{month}").permitAll()
                .antMatchers("/thongke/**").permitAll()
                .antMatchers("/api/payment/**").permitAll()
                .antMatchers("/api/User/**").hasAnyAuthority("ADMIN","MANAGER")
                .anyRequest().authenticated();
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
