package cz.upce.bank.eb.dao;

import cz.upce.bank.eb.entity.NewCreditRequest;
import cz.upce.bank.eb.entity.PayCreditRequest;
import cz.upce.bank.eb.entity.Uvery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Service
public class UveryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void newCredit(NewCreditRequest request) {
        String query = "INSERT INTO UVERY(DATUM_POSKYTNUTI, ZBYVAJICI_CASTKA, TYP_UVERU_ID, UCTY_ID) " +
                        "VALUES(SYSDATE, ?, ?, ?)";
        jdbcTemplate.update(query, new Object[] {request.getAmount(), request.getTypeId(), request.getAccountId()});
    }

    public Uvery getUver(Integer creditId) {
        String query = "SELECT * FROM UDAJE_O_UVERECH WHERE ID = ?";
        List<Uvery> foundCredits = jdbcTemplate.query(query, new Object[]{creditId}, Uvery.getUveryMapper());
        if(foundCredits.size() < 1) throw new DaoException("Credit with ID " + creditId + " was not found");
        return foundCredits.get(0);
    }

    @Transactional(rollbackFor = Exception.class)
    public Uvery updateUver(Integer uverId, Uvery uverData) {
        String query = "UPDATE UVERY SET ZBYVAJICI_CASTKA = ? WHERE ID = ?";
        jdbcTemplate.update(query, new Object[] {uverData.getRemainder(), uverId});
        return uverData;
    }

    @Transactional(rollbackFor = Exception.class)
    public void payUver(PayCreditRequest request) throws SQLException {
        try(Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            CallableStatement callableStatement = connection.prepareCall("{call ZAPLAT_UVER(?, ?, ?)}");
            callableStatement.setInt(1, request.getAccountId());
            callableStatement.setInt(2, request.getCreditId());
            callableStatement.setInt(3, request.getAmount());
            callableStatement.executeUpdate();
        }
    }
}
