package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.RecommendationsDao;
import cz.upce.bank.eb.entity.IdRequest;
import cz.upce.bank.eb.entity.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecommendationsService {


    @Autowired
    RecommendationsDao recommendationsDao;

    public void createNewRecommendation(Recommendation newRecommendation) {
        recommendationsDao.createNewRecommendation(newRecommendation);
    }

    public Recommendation[] getAllRecommendations() {
        return recommendationsDao.getAllRecommendations();
    }

    public void declineRecommendations(IdRequest selectedIds) {
        recommendationsDao.declineRecommendations(selectedIds);
    }

    public void approveRecommendations(IdRequest selectedIds) {
        recommendationsDao.approveRecommendations(selectedIds);
    }
}
