package com.Arobs.Meetup.controller;

import java.io.IOException;
import java.util.List;

import com.Arobs.Meetup.service.UserService.UserDTO;
import com.Arobs.Meetup.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> listUsers() {
        return  ResponseEntity.ok(userService.findAllUsers());
    }


    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO theUser) throws IOException {
        userService.saveUser(theUser);
        return ResponseEntity.ok("User saved");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestParam("UserId") int theId) {
        userService.removeUser(theId);
        return ResponseEntity.ok("User deleted");
    }

    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UserDTO theUser) throws IOException {
        userService.updateUser(theUser);
        return ResponseEntity.ok("User updated");
    }

    @GetMapping("/getUser")
        public ResponseEntity<UserDTO> getUser(@RequestParam("UserEmail") String email , @RequestParam("UserPassword") String password) throws Exception {

            UserDTO userDTO = userService.findByEmailAndPassword(email, password);
            return ResponseEntity.ok(userDTO);


        }


}
