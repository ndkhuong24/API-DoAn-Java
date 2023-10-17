package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthencationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
//        String token = extractTokenFromRequest(request);
//            String username = jwtUtils.extractUserName(token);
//            if (username != null) {
//                // Tạo đối tượng Authentication và đặt nó trong SecurityContextHolder
//                UsernamePasswordAuthenticationToken authentication =
//                        new UsernamePasswordAuthenticationToken(username, null, null);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//
//
//        filterChain.doFilter(request, response);
        String token = extractTokenFromRequest(request);
        if (token != null) {
            String username = jwtUtils.extractUserName(token);
            if (username != null) {
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
    public String extractTokenFromRequest(HttpServletRequest request) {
        // Lấy giá trị tiêu đề "Authorization" từ yêu cầu
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            // Nếu tiêu đề "Authorization" tồn tại và bắt đầu bằng "Bearer ", trả về token đã cắt bỏ "Bearer "
            return header.substring(7); // 7 là độ dài của chuỗi "Bearer "
        }

        // Nếu không tìm thấy token trong tiêu đề "Authorization", bạn có thể thử trích xuất token từ nơi khác,
        // ví dụ: từ tham số trong URL hoặc từ cookie, tùy thuộc vào cách bạn cung cấp token.

        return null; // Trả về null nếu không tìm thấy hoặc token không hợp lệ
    }

}
