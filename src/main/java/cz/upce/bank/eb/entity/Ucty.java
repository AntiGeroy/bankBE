package cz.upce.bank.eb.entity;

import org.springframework.jdbc.core.RowMapper;

public class Ucty {

    private int accountId;
    private int clientId;
    private String accountNumber;
    private String state;

    public static RowMapper<Ucty> getUctyMapper() {
        return (rs, rowNum) -> {
            Ucty ucty = new Ucty();
            ucty.setAccountId(rs.getInt("UCET_ID"));
            ucty.setClientId(rs.getInt("KLIENT_ID"));
            ucty.setAccountNumber(rs.getString("CISLO_UCTU"));
            ucty.setState(rs.getString("POPIS"));
            return ucty;
        };
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
