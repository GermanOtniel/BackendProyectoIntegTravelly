package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthService extends JpaRepository<User, Integer> {
    /* Seleccionar usuario, si sus credenciales son correctas */
    @Query("select u from User u where u.email = ?1")
    public User loginUser(String email);

}
