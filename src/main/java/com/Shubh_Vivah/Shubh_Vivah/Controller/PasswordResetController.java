package com.Shubh_Vivah.Shubh_Vivah.Controller;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;   // ye import add karo
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Shubh_Vivah.Shubh_Vivah.Model.User;
import com.Shubh_Vivah.Shubh_Vivah.Repository.UserRepository;
@Controller
public class PasswordResetController {

    @Autowired private UserRepository userRepository;
    @Autowired private JavaMailSender mailSender;
    @Autowired private PasswordEncoder passwordEncoder;

     @Value("${app.base-url:https://shubh-vivah-24av.onrender.com}")
     private String baseUrl;
    @GetMapping("/forgot-password")
    public String showForgotForm() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String processForgot(@RequestParam("email") String email, Model model) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty()) {
            model.addAttribute("errorMsg", "No account found with this email.");
            return "forgot-password";
        }

        User user = userOpt.get();
        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        user.setResetTokenExpiry(LocalDateTime.now().plusMinutes(30));
        userRepository.save(user);

        String resetLink = baseUrl + "/reset-password?token=" + token;   // <-- yaha use hoga

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Shubh Vivah - Password Reset Request");
        message.setText("Password reset ke liye click karo:\n" + resetLink +
                "\n\nYe link 30 minute me expire ho jayega.");
        mailSender.send(message);

        model.addAttribute("successMsg", "Password reset link aapke email par bhej diya gaya hai.");
        return "forgot-password";
    }

    // baaki methods same rahenge...
}
