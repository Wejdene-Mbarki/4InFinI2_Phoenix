package tn.esprit.InFinI_Phoenix.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.esprit.InFinI_Phoenix.entities.User;
import tn.esprit.InFinI_Phoenix.services.IUserServices;
import tn.esprit.InFinI_Phoenix.services.UserServicesImpl;

import java.util.List;

@RestController

@RequestMapping("/User")
public class UserRestController {
    @Autowired
    private UserServicesImpl userServices;

    @PostMapping("/add")
   public User addUser(@RequestBody User user) {
        return userServices.addUser(user);
    }
    @GetMapping("/all")
   public List<User> getAllUsers(){
        return userServices.retrieveAllUsers();
   }
   @PutMapping("/update/{idUser}")
   public User updateUser(@PathVariable Long idUser,@Validated @RequestBody User user) throws Exception{
        return userServices.updateUser(idUser,user);
   }
   @DeleteMapping("/delete/{idUser}")
   public String deleteUser(@PathVariable Long idUser)throws Exception{
        return userServices.removeUser(idUser);
   }
}

