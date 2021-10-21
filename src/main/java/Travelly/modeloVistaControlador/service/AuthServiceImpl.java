package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl /*implements AuthService*/{
    @Autowired
    private UserService userService;

//    @Override
    public void registerUser(User user) {
        /*UserServiceImpl.usersRepo.put(user.getUserId(),user);*/
        userService.save(user);
    }

//    @Override
    public Object loginUser(String email, String password) {
        return  new Object();
        /*for (User user : UserServiceImpl.usersRepo.values()) {
            if (user.getEmail().equals(email)) {
                if(user.getPassword().equals(password)) {
                    return user;
                }else{
                    return "Credenciales inválidas";
                }
            }
        }
        return "Usuario no registrado";*/
    }
}
