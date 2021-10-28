package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.Chat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ChatService extends CrudRepository<Chat, Integer> {
    @Query("select c from Chat c where (c.user.userId = ?1 and c.followedUser.userId = ?2) or (c.user.userId = ?2 and c.followedUser.userId = ?1) order by c.sendAt ")
    public List<Chat> findConversation(int userId, int followedUserId);
}
