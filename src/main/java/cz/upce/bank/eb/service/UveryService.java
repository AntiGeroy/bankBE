package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.UveryDao;
import cz.upce.bank.eb.entity.PayCreditRequest;
import cz.upce.bank.eb.entity.Uvery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class UveryService {
    
    @Autowired
    private UveryDao uveryDao;

    public Uvery getUver(Integer creditId) {
        return uveryDao.getUver(creditId);
    }

    public Uvery updateUver(Integer uverId, Uvery uverData) {
        return uveryDao.updateUver(uverId, uverData);
    }

    public void payUver(PayCreditRequest request) throws SQLException {
        uveryDao.payUver(request);
    }
}
