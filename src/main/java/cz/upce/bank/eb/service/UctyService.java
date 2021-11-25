package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.UctyDao;
import cz.upce.bank.eb.entity.NewAccountRequest;
import cz.upce.bank.eb.entity.Ucty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UctyService {

    @Autowired
    private UctyDao uctyDao;

    public Ucty getUcetById(Integer ucetId){
        Ucty foundAccount =  uctyDao.getUcetById(ucetId);
        if (foundAccount == null){
            throw new ServiceException("Account was not found");
        }
        return foundAccount;
    }

    public void freezeAccount(Integer accountId) throws Exception{
        uctyDao.freezeAccount(accountId);
    }

    public void unfreezeAccount(Integer accountId) throws Exception{
        uctyDao.unfreezeAccount(accountId);
    }

    public void createNewAccount(NewAccountRequest account){
        uctyDao.createNewAccount(account);
    }


}
