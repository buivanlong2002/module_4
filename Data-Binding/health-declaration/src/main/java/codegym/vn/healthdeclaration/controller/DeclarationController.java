package codegym.vn.healthdeclaration.controller;

import codegym.vn.healthdeclaration.model.HealthDeclaration;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/declaration")
public class DeclarationController {

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("declaration", new HealthDeclaration());
        return "form";
    }

    @PostMapping
    public String submitForm(@Valid @ModelAttribute("declaration") HealthDeclaration declaration,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        // Lưu vào session/database nếu cần

        return "result"; // hiển thị lại thông tin đã khai
    }
}

