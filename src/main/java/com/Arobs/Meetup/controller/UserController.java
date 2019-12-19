package com.Arobs.Meetup.controller;

import java.util.List;

import com.Arobs.Meetup.service.UserService.UserDTO;
import com.Arobs.Meetup.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserDTO> listUsers() {
        return  userService.findAllUsers();
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        UserDTO theUser = new UserDTO();
        theModel.addAttribute("User", theUser);
        return "User-form";
    }

    @PostMapping("/saveUser")
    public void saveUser(@ModelAttribute("User") UserDTO theUser) {
        userService.saveUser(theUser);

    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("UserId") int theId,
                                    Model theModel) {
        UserDTO theUser = userService.findUserById(theId);
        theModel.addAttribute("User", theUser);
        return "User-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("UserId") int theId) {
        userService.removeUser(theId);
        return "redirect:/User/list";
    }
}
