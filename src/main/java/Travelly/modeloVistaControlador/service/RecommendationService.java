package Travelly.modeloVistaControlador.service;

import java.util.Collection;
import Travelly.modeloVistaControlador.model.Recommendation;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
public interface RecommendationService extends CrudRepository<Recommendation, Integer> {
    /*public abstract void createRecommendation(Recommendation recommendation);
    public abstract void updateRecommendation(int recommID,Recommendation recommendation);
    public abstract void deleteRecommendation(int recommID);
    public abstract Collection<Recommendation> getRecommendations();*/
}
