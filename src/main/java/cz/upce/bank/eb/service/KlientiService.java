package cz.upce.bank.eb.service;


import cz.upce.bank.eb.dao.KlientiDao;
import cz.upce.bank.eb.entity.Klienti;
import cz.upce.bank.eb.entity.KlientiAdresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KlientiService {

    @Autowired
    private KlientiDao klientiDao;

    public Klienti getClientById(Integer clientId){
        return klientiDao.getClientById(clientId);
    }

    public Klienti updateClient(Integer clientId, Klienti clientData){
        return klientiDao.updateClient(clientId, clientData);
    }

    public KlientiAdresy[] getClientsOnAddress(Integer addressId) {
        return klientiDao.getClientsOnAddress(addressId);
    }

    public KlientiAdresy updateClientAddressState(KlientiAdresy clientAddress) {
        return klientiDao.updateClientAddressState(clientAddress);
    }
}
