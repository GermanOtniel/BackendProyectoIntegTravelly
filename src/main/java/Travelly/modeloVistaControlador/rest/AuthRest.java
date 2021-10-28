package Travelly.modeloVistaControlador.rest;
import Travelly.modeloVistaControlador.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Travelly.modeloVistaControlador.model.User;
import Travelly.modeloVistaControlador.service.AuthService;

import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import java.util.List;
import org.springframework.security.core.authority.AuthorityUtils;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthRest {
    @Autowired
    AuthService authService;
    @Autowired
    UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {

        User userRegistered = userService.save(user);
        String token = getJWTToken(userRegistered.getEmail());
        userRegistered.setAuthToken(token);
        System.out.println();
        return new ResponseEntity<>(userRegistered, HttpStatus.CREATED);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Object> loginUser(@RequestBody User user) {

        User userLogged = authService.loginUser(user.getEmail());
        if (userLogged == null) {
            return new ResponseEntity<>(
                    "{\"message\": \"Usuario no registrado\", \"error\": \"true\"}",
                    HttpStatus.NOT_FOUND
            );
        } else {
            if (!userLogged.getPassword().equals(user.getPassword())) {
                return new ResponseEntity<>(
                        "{\"message\": \"Credenciales inválidas\",  \"error\": \"true\"}",
                        HttpStatus.UNAUTHORIZED
                );
            }
        }
        String token = getJWTToken(userLogged.getEmail());
        userLogged.setAuthToken(token);
        return new ResponseEntity<>(userLogged, HttpStatus.OK);
    }

    private String getJWTToken(String email) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(email)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 6000000 * 10))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}