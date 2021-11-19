package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.AdresyDao;
import cz.upce.bank.eb.entity.Adresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresyService {

    @Autowired
    private AdresyDao adresyDao;

    public Adresy getAddressById(Integer addressId){
        return adresyDao.getAddressById(addressId);
    }

}
