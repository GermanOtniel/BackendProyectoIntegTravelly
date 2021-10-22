package Travelly.modeloVistaControlador.service;

import java.util.Collection;

import Travelly.modeloVistaControlador.model.Comment;
import Travelly.modeloVistaControlador.model.Recommendation;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
public interface CommentService extends CrudRepository<Comment, Integer> {

}
