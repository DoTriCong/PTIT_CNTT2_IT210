package org.example.ss2.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.example.ss2.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public String orders(HttpSession session, Model model) {
        // Chuyển về login nếu chưa đăng nhập
        if (session.getAttribute("username") == null) {
            return "redirect:/login";
        }

        // Lấy ra thông tin
        String username = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        // Danh sách đơn hàng
        List<Order> list = new ArrayList<>();
        list.add(new Order("Giày nữ", 100000));
        list.add(new Order("Áo nữ", 200000));
        list.add(new Order("Quần nữ", 300000));

        // Tăng biến đếm
        ServletContext context = session.getServletContext();
        int count = increase(context);

        // Thêm vào model
        model.addAttribute("username", username);
        model.addAttribute("role", role);
        model.addAttribute("list", list);
        model.addAttribute("count", count);
        return "orders";
    }

    private synchronized int increase(ServletContext context) {
        Integer count = (Integer) context.getAttribute("totalViewCount");
        if (count == null) {
            count = 0;
        }
        count++;
        context.setAttribute("totalViewCount", count);
        return count;
    }
}
