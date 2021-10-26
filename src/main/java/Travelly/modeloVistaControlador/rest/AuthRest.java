package Travelly.modeloVistaControlador.rest;

import Travelly.modeloVistaControlador.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import Travelly.modeloVistaControlador.model.User;
import Travelly.modeloVistaControlador.service.AuthService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class AuthRest {
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
//        authService.registerUser(user);
        userService.save(user);
        return new ResponseEntity<>("User is register successfully", HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user) {
        User loggedUser = authService.loginUser(user.getEmail(), user.getPassword());
        String loggedToken = getJWTToken(loggedUser.getEmail());
        loggedUser.setToken(loggedToken);
        return new ResponseEntity<>(loggedUser, HttpStatus.OK);
    }


    private String getJWTToken(String userEmail) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String loggedToken = Jwts
                .builder()
                .setId("Travelly")
                .setSubject(userEmail)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + loggedToken;
    }
}