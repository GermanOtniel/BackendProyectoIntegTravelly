package Travelly.modeloVistaControlador.service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;
import Travelly.modeloVistaControlador.model.User;

/*@Service*/
public class UserServiceImpl /*implements UserService */{

    public static Map<Integer, User> usersRepo = new HashMap<>();

    /*@Override*/
    public void createUser(User user) {

        usersRepo.put(user.getUserId(),user);
    }

    /*@Override*/
    public void updateUser(int userID, User user) {
        usersRepo.remove(userID);
        user.setUserId(userID);
        usersRepo.put(userID,user);

    }

    /*@Override*/
    public void deleteUser(int userID) {

        usersRepo.remove(userID);
    }

    /*@Override*/
    public Collection<User> getUsers() {

        return usersRepo.values();
    }
}
