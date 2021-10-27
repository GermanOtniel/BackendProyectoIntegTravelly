package Travelly.modeloVistaControlador.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import Travelly.modeloVistaControlador.model.User;
import Travelly.modeloVistaControlador.service.UserService;

import java.util.Optional;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserRest {
    @Autowired
    UserService userService;

    @GetMapping(path = "/users")
    public ResponseEntity<Object> getUsers() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<Object>
    updateUser(@PathVariable("id") Integer id, @RequestBody User user) {

        User updatedUser= userService.findById(id).get();
        updatedUser.setBirthday(user.getBirthday());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setName(user.getName());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setProfilePicture(user.getProfilePicture());
        updatedUser.setTelephone(user.getTelephone());
        userService.save(updatedUser);

        return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        /*User newUser = new User();
        newUser.setBirthday(user.getBirthday());
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setPassword(user.getPassword());
        newUser.setProfilePicture(user.getProfilePicture());
        newUser.setTelephone(user.getTelephone());*/

        userService.save(user);
        return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
    }
}