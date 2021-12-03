package cz.upce.bank.eb.service;


import cz.upce.bank.eb.controller.StatisticsController;
import cz.upce.bank.eb.dao.StatisticsDao;
import cz.upce.bank.eb.entity.AccountStatistics;
import cz.upce.bank.eb.entity.ProfitInPeriodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class StatisticsService {

    @Autowired
    StatisticsDao statisticsDao;

    public AccountStatistics getAccountStatistics() throws SQLException {
        return statisticsDao.getAccountStatistics();
    }

    public int getTotalBankCapital() throws SQLException {
        return statisticsDao.getTotalBankCapital();
    }

    public int getProfitInPeriod(String dateFrom, String dateTo) {
        return statisticsDao.getProfitInPeriod(dateFrom, dateTo);
    }
}
