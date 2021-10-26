package Travelly.modeloVistaControlador.service;

import java.util.List;

import Travelly.modeloVistaControlador.model.Recommendation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecommendationService extends CrudRepository<Recommendation, Integer> {
    /* Seleccionar recomendaciones de acuerdo a su categoría */
    @Query("select r from Recommendation r where r.category.name = ?1")
    public List<Recommendation> findAllByCategory(String category);
}
