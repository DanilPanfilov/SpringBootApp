package com.example.SpringBootApp.controller;

import com.example.SpringBootApp.model.User;
import com.example.SpringBootApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")// то что указывается в браузере
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";// на какую hml страницу смотримxs
    }

    @PostMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, @ModelAttribute("user") User user) {
        userService.update(id, user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "edit";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
}
