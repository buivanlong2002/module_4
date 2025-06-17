package com.codegym.practice_2.controller;


import com.codegym.practice_2.model.Customer;
import com.codegym.practice_2.service.CustomerService;
import com.codegym.practice_2.service.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    private SimpleCustomerServiceImpl customerService;

    // Hiển thị danh sách khách hàng
    @GetMapping("/customers")
    public String showList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }

    // Hiển thị chi tiết khách hàng theo id
    @GetMapping("/customer")
    public String showInfo(@RequestParam int id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            return "error"; // hoặc trang lỗi bạn tự tạo
        }
        model.addAttribute("customer", customer);
        return "info";
    }
}