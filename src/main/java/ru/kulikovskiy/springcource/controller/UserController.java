package ru.kulikovskiy.springcource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kulikovskiy.springcource.model.User;
import ru.kulikovskiy.springcource.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/delete")
    public String deleteUser(@ModelAttribute("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.showUser(id));
        return "userUpdate";
    }

    @PostMapping("{id}/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/newUser")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }
}
