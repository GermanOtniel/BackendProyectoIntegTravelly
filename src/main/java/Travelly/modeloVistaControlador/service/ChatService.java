package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.Chat;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
public interface ChatService extends CrudRepository<Chat, Integer> {
}
