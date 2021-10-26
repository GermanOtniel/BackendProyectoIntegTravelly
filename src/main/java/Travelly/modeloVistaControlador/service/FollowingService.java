package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.Following;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
public interface FollowingService extends CrudRepository<Following, Integer>{
}
