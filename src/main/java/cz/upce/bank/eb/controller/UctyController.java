package cz.upce.bank.eb.controller;

import cz.upce.bank.eb.entity.Ucty;
import cz.upce.bank.eb.service.UctyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ucty")
@CrossOrigin(origins = "*")
public class UctyController {

    @Autowired
    private UctyService uctyService;

    @GetMapping("/{accountId}")
    public @ResponseBody
    Ucty getClient(@PathVariable("accountId") Integer accountId) {
        return uctyService.getUcetById(accountId);
    }

}
