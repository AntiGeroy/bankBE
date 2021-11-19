package cz.upce.bank.eb.dao;

import cz.upce.bank.eb.entity.Adresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import java.sql.PreparedStatement;
import java.util.List;

@Service
public class AdresyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Adresy createNewAddress(Adresy adresy){
        String sql = "INSERT INTO ADRESY (CISLO_POPISNE, ULICE, MESTO, PSC, KOD_ZEME)" +
                " VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql, new String[] { "ID" });
            ps.setString(1, adresy.getHouseNumber());
            ps.setString(2, adresy.getStreet());
            ps.setString(3, adresy.getTown());
            ps.setString(4, adresy.getPostalCode());
            ps.setString(5, adresy.getCountryCode());
            return ps;
        }, keyHolder);

        int generatedId = keyHolder.getKey().intValue();
        adresy.setAddressId(generatedId);
        return adresy;
    }

    public void bindAddressToClient(Adresy adresy) {
        String sql = "INSERT INTO KLIENTI_ADRESY (KLIENTI_ID, ADRESY_ID)" +
                "VALUES (?, ?)";

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(sql);
            ps.setInt(1, adresy.getClientId());
            ps.setInt(2, adresy.getAddressId());
            return ps;
        });
    }

    public Adresy getAddressById(Integer addressId){
        String query = "SELECT * FROM ADRESY WHERE ID = ?";
        List<Adresy> foundAddresses  = jdbcTemplate.query(query, new Object[]{addressId}, Adresy.getAdresyMapper());
        if (foundAddresses.size() != 1){
            throw new DaoException("Address with ID " + addressId + " not found");
        }
        return foundAddresses.get(0);
    }

}
