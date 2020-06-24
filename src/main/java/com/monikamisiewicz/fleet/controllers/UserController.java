package com.monikamisiewicz.fleet.controllers;

import com.monikamisiewicz.fleet.models.User;
import com.monikamisiewicz.fleet.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String getUsers() {
        return "user";
    }

    //Modified method to Add a new user User
    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {

        userService.save(user);

        RedirectView  redirectView= new RedirectView("/login",true);
        redir.addFlashAttribute("message",	"You successfully registered! You can now login");

        return redirectView;
    }


}
