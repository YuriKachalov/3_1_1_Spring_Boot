package ru.kachalov.springweb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kachalov.springweb.model.User;
import ru.kachalov.springweb.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUser(Model model) {
        List<User> user = userService.listUsers();
        model.addAttribute("users", user);
        return "users";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/user-delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }


    @GetMapping("/user-update")
    public String сhangeUserId(@RequestParam("id") int id, Model model) {
        User user = userService.getUserId(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    @PostMapping("/user-update")
    public String сhangeUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }
}
