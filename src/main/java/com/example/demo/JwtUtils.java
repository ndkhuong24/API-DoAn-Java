package com.example.demo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class JwtUtils {
    private static final String SECRET_KEY = "haha"; // Đây là khóa bí mật

    private static final long EXPIRATION_TIME =3600000; // Thời gian hết hạn của access token (1 giờ)


    public String generateAccessToken(Authentication authentication) {
        String username=authentication.getName();
        Date now = new Date();
        Date expirationTime = new Date(now.getTime() + EXPIRATION_TIME);

        String accessToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        return accessToken;
    }
    // validate token
    public Claims validateAccessToken(String accessToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(accessToken)
                    .getBody();
            return claims;
        } catch (Exception e) {
            // Xử lý lỗi nếu access token không hợp lệ
            throw new RuntimeException("Access token is invalid");
        }
    }
        //lay thong tin khi co accesstoken
        public String extractUserName(String token) {
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(token)
                        .getBody();
                return claims.getSubject(); // Trả về thông tin tên người dùng từ subject của token
            } catch (Exception e) {
                // Xử lý lỗi nếu có
                return null;
            }
        }
    //refreshToken
    public String generateRefreshToken(String userName) {
        // Tạo chuỗi token với nội dung là userName
        String refreshToken = Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return refreshToken;
    }

}
