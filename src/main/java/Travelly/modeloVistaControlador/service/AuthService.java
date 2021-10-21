package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthService extends JpaRepository<User, Integer> {
//    public abstract void registerUser(User user);
    @Query("select u from User u where u.email = ?1 and u.password = ?2")
    public User loginUser(String email, String password);

}
