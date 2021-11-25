package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.TransakceDao;
import cz.upce.bank.eb.entity.NewTransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransakceService {

    @Autowired
    private TransakceDao transakceDao;

    public void addNewTransaction(NewTransactionRequest request) throws Exception{
        transakceDao.addNewTransaction(request);
    }

}
