package Travelly.modeloVistaControlador.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import Travelly.modeloVistaControlador.model.Recommendation;

//@Service
public class recommendationServiceImpl /*implements recommendationService*/{
    private static Map<Integer, Recommendation> recommendationsRepo = new HashMap<>();

    //@Override
    public void createRecommendation(Recommendation recommendation) {
        recommendationsRepo.put(recommendation.getRecommID(), recommendation);
    }

    //@Override
    public void updateRecommendation(int recommID, Recommendation recommendation) {
        recommendationsRepo.remove(recommID);
        recommendation.setRecommID(recommID);
        recommendationsRepo.put(recommID, recommendation);
    }

    //@Override
    public void deleteRecommendation(int recommID) {
        recommendationsRepo.remove(recommID);
    }

    //@Override
    public Collection<Recommendation> getRecommendations() {
        return recommendationsRepo.values();
    }
}
