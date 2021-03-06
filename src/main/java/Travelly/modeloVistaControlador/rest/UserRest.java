package Travelly.modeloVistaControlador.rest;


import Travelly.modeloVistaControlador.service.FollowingService;
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

    @Autowired
    FollowingService followService;

    @GetMapping(path = "/users")
    public ResponseEntity<Object> getUsers() {

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<Object>
    updateUser(@PathVariable("id") Integer id, @RequestBody User user) {

        User updatedUser = userService.findById(id).get();
        updatedUser.setBirthday(user.getBirthday());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setName(user.getName());
        updatedUser.setProfilePicture(user.getProfilePicture());
        updatedUser.setTelephone(user.getTelephone());
        updatedUser.setAboutMe(user.getAboutMe());
        User userUpdated = userService.save(updatedUser);

        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        userService.save(user);
        return new ResponseEntity<>("User is created successfully", HttpStatus.CREATED);
    }

    @GetMapping(path = "/users/{id}/following")
    public ResponseEntity<Object> getUserFollowing(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(followService.findByUserId(id), HttpStatus.OK);
    }
}