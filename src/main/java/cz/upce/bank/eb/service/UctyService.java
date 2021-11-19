package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.UctyDao;
import cz.upce.bank.eb.entity.Ucty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UctyService {

    @Autowired
    private UctyDao uctyDao;

    public Ucty getUcetById(Integer ucetId){
        return uctyDao.getUcetById(ucetId);
    }


}
