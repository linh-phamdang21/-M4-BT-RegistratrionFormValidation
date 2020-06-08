package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequestMapping("/")
@Controller
public class FormController {

    @GetMapping
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("checkValid")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("message", "Error");
            return "home";
        }
        ModelAndView modelAndView = new ModelAndView("success");
        return "success";
    }
}
