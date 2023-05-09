package com.g2.t5;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuiController {
    @GetMapping("/main")
    public String GUIController(Model model) {
        String nome = "Arctic Network";

        model.addAttribute("nome", nome);
        return "main";
    }

}
