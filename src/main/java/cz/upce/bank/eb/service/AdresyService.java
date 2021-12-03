package cz.upce.bank.eb.service;

import cz.upce.bank.eb.dao.AdresyDao;
import cz.upce.bank.eb.entity.Adresy;
import cz.upce.bank.eb.entity.Klienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class AdresyService {

    @Autowired
    private AdresyDao adresyDao;

    @Transactional(rollbackFor = Exception.class)
    public Adresy createNewAddress(Adresy adresy) throws SQLException {
        int addId = adresyDao.createAddressAndBindToClient(adresy);
        adresy.setClientId(addId);
        return adresy;
    }


    public Adresy getAddressById(Integer addressId){
        return adresyDao.getAddressById(addressId);
    }

    public Adresy updateAddress(Integer addressId, Adresy addressData) {
        return adresyDao.updateAddress(addressId, addressData);
    }
}
