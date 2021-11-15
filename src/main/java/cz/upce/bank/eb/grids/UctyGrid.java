package cz.upce.bank.eb.grids;

import cz.upce.bank.eb.entity.Ucty;
import mk.gridlib.builders.GridConfigBuilder;
import mk.gridlib.domain.grid.GridConfig;
import mk.gridlib.enums.CONTENTTYPE;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UctyGrid {

    @Bean
    public GridConfig<Ucty> getAllAccounts() {
        return GridConfigBuilder.createGrid(Ucty.class, "accountId")
                .gridName("Accounts")
                .unlimitedRowsCount()
                .column("accountNumber").tableColumn("CISLO_UCTU").label("Číslo účtu").contentType(CONTENTTYPE.TEXT).end()
                .hiddenColumn("accountId").tableColumn("UCET_ID").contentType(CONTENTTYPE.TEXT).end()
                .hiddenColumn("clientId").tableColumn("KLIENT_ID").contentType(CONTENTTYPE.TEXT).end()
                .column("state").tableColumn("POPIS").contentType(CONTENTTYPE.TEXT).end()
                .build();
    }
}