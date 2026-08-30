package com.Shubh_Vivah.Shubh_Vivah.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Shubh_Vivah.Shubh_Vivah.Config.CustomUserDetails;

@Controller
public class LoginController {

    @GetMapping("/wedding")
    public String showloginpage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String showDashboard(@AuthenticationPrincipal CustomUserDetails principal, Model model) {
        model.addAttribute("user", principal.getUser());
        return "dashboard";
    }
}
