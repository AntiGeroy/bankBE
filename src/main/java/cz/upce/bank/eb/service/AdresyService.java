package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.AdresyDao;
import cz.upce.bank.eb.entity.Adresy;
import cz.upce.bank.eb.entity.Klienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdresyService {

    @Autowired
    private AdresyDao adresyDao;

    @Transactional(rollbackFor = Exception.class)
    public Adresy createNewAddress(Adresy adresy){
        Adresy adresyCheck = adresyDao.getAddressByFields(adresy);

        if(adresyCheck == null){
            adresy = adresyDao.createNewAddress(adresy);
        } else {
            adresy.setAddressId(adresyCheck.getAddressId());
        }

        if(!adresyDao.checkIfAddressIsBoundToClient(adresy)){
            adresyDao.bindAddressToClient(adresy);
        }
        return adresy;
    }


    public Adresy getAddressById(Integer addressId){
        return adresyDao.getAddressById(addressId);
    }

    public Adresy updateAddress(Integer addressId, Adresy addressData) {
        return adresyDao.updateAddress(addressId, addressData);
    }
}
