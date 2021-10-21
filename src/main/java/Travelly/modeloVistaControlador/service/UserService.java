package Travelly.modeloVistaControlador.service;

import java.util.Collection;
import Travelly.modeloVistaControlador.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService extends CrudRepository<User, Integer> {
    //public abstract void createUser(User user);
    //public abstract void updateUser(int userID,User user);
    //public abstract void deleteUser(int userID);
    //public abstract Collection<User> getUsers();
}
