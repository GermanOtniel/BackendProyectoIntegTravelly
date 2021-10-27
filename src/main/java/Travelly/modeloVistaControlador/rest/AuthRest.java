package Travelly.modeloVistaControlador.rest;
import Travelly.modeloVistaControlador.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Travelly.modeloVistaControlador.model.User;
import Travelly.modeloVistaControlador.service.AuthService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthRest {
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
//        authService.registerUser(user);
        userService.save(user);
        return new ResponseEntity<>("{\"text\":\"User is register successfully\"}", HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user) {
        return new ResponseEntity<>(authService.loginUser(user.getEmail(), user.getPassword()), HttpStatus.OK);
    }
}