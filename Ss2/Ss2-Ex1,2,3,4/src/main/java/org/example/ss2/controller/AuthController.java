package org.example.ss2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {
    @GetMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        if (username.equals("admin") && password.equals("admin123") || username.equals("staff") && password.equals("staff123")) {
            session.setAttribute("username", username);
            String role = username.equals("admin") ? "admin" : "staff";
            session.setAttribute("role", role);
            return "redirect:/orders";
        }
        model.addAttribute("error", "Thông tin đăng nhập không chính xác");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
