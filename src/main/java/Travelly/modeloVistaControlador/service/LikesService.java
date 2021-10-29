package Travelly.modeloVistaControlador.service;

import Travelly.modeloVistaControlador.model.Likes;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikesService extends CrudRepository<Likes, Integer> {
    @Query("select l from Likes l where l.userId = ?1 and l.recommendationId = ?2")
    public List<Likes> findByUserIdAndRecommendationId(Integer userId, Integer recommendationId);
}
