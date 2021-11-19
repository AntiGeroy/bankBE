package cz.upce.bank.eb.dao;

import cz.upce.bank.eb.entity.Adresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Adresy getAddressById(Integer addressId){
        String query = "SELECT * FROM ADRESY WHERE ID = ?";
        List<Adresy> foundAddresses  = jdbcTemplate.query(query, new Object[]{addressId}, Adresy.getAdresyMapper());
        if (foundAddresses.size() != 1){
            throw new DaoException("Address with ID " + addressId + " not found");
        }
        return foundAddresses.get(0);
    }

}
