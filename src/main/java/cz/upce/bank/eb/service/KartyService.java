package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.KartyDao;
import cz.upce.bank.eb.entity.Karty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KartyService {

    @Autowired
    private KartyDao kartyDao;

    public Karty getCardById(Integer cardId) {
        return kartyDao.getCardById(cardId);
    }

    public void freezeCard(Integer cardId) {
        kartyDao.freezeCard(cardId);
    }

    public void unfreezeCard(Integer cardId) {
        kartyDao.unfreezeCard(cardId);
    }

    public void terminateCard(Integer cardId) {
        kartyDao.terminateCard(cardId);
    }
}
