package com.example.demo.service.user;

import com.example.demo.model.Users;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ForgotPassWordService {
    private static final long EXPIRE_TOKEN = 30;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    private JavaMailSender mailSender;

    public String forgotPass(String email) {
        Users user = userRepository.findByEmail(email);

        if (user == null) {
            return "Invalid email id.";
        }

        // user.setToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());

        user = userRepository.save(user);
        // Gửi email với token
        try {
            sendResetPasswordEmail(email);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending email.";
        }

        return "An email with instructions has been sent to your email address.";
    }

    public String resetPass(String email, String password) {
        Optional<Users> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
//
//        if(!userOptional.isPresent()){
//            return "Invalid token";
//        }
//        LocalDateTime tokenCreationDate = userOptional.get().getTokenCreationDate();
//        if (isTokenExpired(tokenCreationDate)) {
//            return "Token expired.";
//
//        }

        Users user = userOptional.get();

        user.setPassword(password);
        user.setToken(null);
        user.setTokenCreationDate(null);

        userRepository.save(user);

        return "Your password successfully updated.";
    }

    //    private String generateToken() {
//        StringBuilder token = new StringBuilder();
//
//        return token.append(UUID.randomUUID().toString())
//                .append(UUID.randomUUID().toString()).toString();
//    }
//
//    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {
//
//        LocalDateTime now = LocalDateTime.now();
//        Duration diff = Duration.between(tokenCreationDate, now);
//
//        return diff.toMinutes() >=EXPIRE_TOKEN;
//    }
    public void sendResetPasswordEmail(String recipientEmail)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(recipientEmail, "Your App Support");
        helper.setTo(recipientEmail);

        String subject = "Reset Your Password";
        helper.setSubject(subject);
        helper.setText("""
                <div>
                  <a href="http://127.0.0.1:5500/email-sent.html" target="_blank">click link to set password</a>
                </div>
                """.formatted(recipientEmail), true);

        mailSender.send(message);
    }
}
