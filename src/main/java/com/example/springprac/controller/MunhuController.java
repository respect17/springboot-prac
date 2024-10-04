package com.example.springprac.controller;

import com.example.springprac.model.Munhu;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.springprac.repository.MunhuRepository;

@Controller
public class MunhuController {

    @Autowired
    private MunhuRepository munhuRepository;

    @GetMapping("/form")
    public String showForm(Munhu munhu) {
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid Munhu munhu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "form";
        }
        munhuRepository.save(munhu);
        model.addAttribute("munhu", munhu);
        return "greeting";
    }
}
