package Travelly.modeloVistaControlador.service;

import java.util.List;

import Travelly.modeloVistaControlador.model.Comment;
import Travelly.modeloVistaControlador.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RecommendationService extends JpaRepository<Recommendation, Integer> {
    /* Seleccionar recomendaciones de acuerdo a su categoría */
    @Query("select r from Recommendation r where r.category.name = ?1")
    public List<Recommendation> findAllByCategory(String category);
    @Query("select c from Comment c where c.recommendationId = ?1")
    public List<Comment> findAllComments(Integer recommId);
}
