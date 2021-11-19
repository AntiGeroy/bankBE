package cz.upce.bank.eb.dao;

import cz.upce.bank.eb.entity.Klienti;
import cz.upce.bank.eb.entity.Ucty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UctyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Ucty getUcetById(Integer clientId){
        String query = "SELECT * FROM UDAJE_O_UCTECH WHERE UCET_ID = ?";
        List<Ucty> foundClients  = jdbcTemplate.query(query, new Object[]{clientId}, Ucty.getUctyMapper());
        if (foundClients.size() != 1){
            throw new DaoException("Account with ID " + clientId + " not found");
        }
        return foundClients.get(0);
    }
}
