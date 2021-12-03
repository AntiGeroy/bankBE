package cz.upce.bank.eb.controller;

import cz.upce.bank.eb.entity.AccountStatistics;
import cz.upce.bank.eb.entity.ProfitInPeriodRequest;
import cz.upce.bank.eb.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/stats")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    @GetMapping("/account")
    public @ResponseBody
    AccountStatistics getAccountStatistics() throws SQLException {
        return statisticsService.getAccountStatistics();
    }

    @GetMapping("/capital")
    public @ResponseBody
    int getTotalBankCapital() throws SQLException {
        return statisticsService.getTotalBankCapital();
    }

    @GetMapping("/profit/{periodFrom}/{periodTo}")
    public @ResponseBody
    int getProfitInPeriod(@PathVariable(name = "periodFrom") String dateFrom, @PathVariable(name = "periodTo") String dateTo) {
        return statisticsService.getProfitInPeriod(dateFrom, dateTo);
    }

}
