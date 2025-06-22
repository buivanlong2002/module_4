package codegym.vn.emailconfig.controller;

import codegym.vn.emailconfig.model.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingsController {

    @GetMapping("/settings")
    public String showForm(Model model) {
        Settings settings = new Settings();
        settings.setLanguage("English");
        settings.setPageSize(25);
        settings.setSpamFilter(false);
        settings.setSignature("Thor\nKing, Asgard");

        model.addAttribute("settings", settings);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});

        return "settings";
    }

    @PostMapping("/settings")
    public String updateSettings(@ModelAttribute Settings settings, Model model) {
        model.addAttribute("settings", settings);
        return "result";
    }
}


