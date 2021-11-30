package cz.upce.bank.eb.dao;

import cz.upce.bank.eb.entity.Klienti;
import cz.upce.bank.eb.entity.KlientiAdresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KlientiDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Klienti getClientById(Integer clientId){
        String query = "SELECT * FROM KLIENTI WHERE ID = ?";
        List<Klienti> foundClients  = jdbcTemplate.query(query, new Object[]{clientId}, Klienti.getClientMapper());
        if (foundClients.size() != 1){
            throw new DaoException("Client with ID " + clientId + " not found");
        }
        return foundClients.get(0);
    }

    public KlientiAdresy[] getClientsOnAddress(Integer addressId) {
        String query = "SELECT KLIENTI_ID, ADRESY_ID, JMENO, PRIJMENI, RODNE_CISLO, AKTIVNI FROM UDAJE_O_ADRESACH_A_KLIENTECH WHERE ADRESY_ID = ?";
        List<KlientiAdresy> foundClients = jdbcTemplate.query(query, new Object[]{addressId}, KlientiAdresy.getClientAddressStateMapper());
        if (foundClients.size() < 1) {
            throw new DaoException("Client on address with ID  " + addressId + " was not found");
        }
        KlientiAdresy[] ka = new KlientiAdresy[foundClients.size()];
        foundClients.toArray(ka);
        return ka;
    }

    @Transactional(rollbackFor = Exception.class)
    public Klienti updateClient(Integer clientId, Klienti modifiedClientInfo){
        Klienti originalClient = getClientById(clientId);

        String query = "UPDATE KLIENTI SET JMENO = ?, PRIJMENI = ?, KONTAKTNI_CISLO = ?, RODNE_CISLO = ?\n" +
                "WHERE ID = ?";

        jdbcTemplate.update(query, new Object[]{modifiedClientInfo.getName(), modifiedClientInfo.getSurname(),
                                modifiedClientInfo.getPhoneNumber(), modifiedClientInfo.getBirthNumber(), clientId});

        return modifiedClientInfo;
    }

    public KlientiAdresy updateClientAddressState(KlientiAdresy clientAddress) {
        String query = "UPDATE KLIENTI_ADRESY SET AKTIVNI = ? WHERE KLIENTI_ID = ? AND ADRESY_ID = ?";
        jdbcTemplate.update(query,new Object[] {clientAddress.getActive(), clientAddress.getClientId(), clientAddress.getAddressId()});
        return clientAddress;
    }
}
