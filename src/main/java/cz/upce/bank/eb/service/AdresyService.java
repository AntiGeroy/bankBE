package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.AdresyDao;
import cz.upce.bank.eb.entity.Adresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdresyService {

    @Autowired
    private AdresyDao adresyDao;

    @Transactional(rollbackFor = Exception.class)
    public Adresy createNewAddress(Adresy adresy){
        adresy = adresyDao.createNewAddress(adresy);
        adresyDao.bindAddressToClient(adresy);
        return adresy;
    }



}
