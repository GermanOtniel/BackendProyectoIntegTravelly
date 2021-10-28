package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.Following;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface FollowingService extends CrudRepository<Following, Integer>{
    @Query("select f from Following f where f.user.userId = ?1")
    List<Following> findByUserId(Integer id);
}
