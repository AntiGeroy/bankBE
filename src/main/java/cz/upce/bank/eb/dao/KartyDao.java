package cz.upce.bank.eb.dao;

import cz.upce.bank.eb.entity.Karty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KartyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Karty getCardById(Integer cardId){
        String query = "SELECT * FROM UDAJE_O_KARTACH WHERE ID = ?";
        List<Karty> foundCards  = jdbcTemplate.query(query, new Object[]{cardId}, Karty.getKartyMapper());
        if (foundCards.size() != 1){
            throw new DaoException("Card with ID " + cardId + " not found");
        }
        return foundCards.get(0);
    }


    public void freezeCard(Integer cardId) {
        String query = "UPDATE KARTY SET STAV_KARTY_ID = 2 WHERE ID = ?";
        jdbcTemplate.update(query, new Object[]{cardId});
    }

    public void unfreezeCard(Integer cardId) {
        String query = "UPDATE KARTY SET STAV_KARTY_ID = 1 WHERE ID = ?";
        jdbcTemplate.update(query, new Object[]{cardId});
    }

    public void terminateCard(Integer cardId) {
        String query = "UPDATE KARTY SET STAV_KARTY_ID = 3 WHERE ID = ?";
        jdbcTemplate.update(query, new Object[]{cardId});
    }
}
