package cz.upce.bank.eb.controller;

import cz.upce.bank.eb.entity.AccountRequest;
import cz.upce.bank.eb.entity.NewAccountRequest;
import cz.upce.bank.eb.entity.Ucty;
import cz.upce.bank.eb.service.UctyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ucty")
public class UctyController {

    @Autowired
    private UctyService uctyService;

    @GetMapping("/{accountId}")
    public @ResponseBody
    Ucty getAccount(@PathVariable("accountId") Integer accountId) {
        return uctyService.getUcetById(accountId);
    }

    @PostMapping("/novy")
    public void addNewAccount(@RequestBody NewAccountRequest account){
        uctyService.createNewAccount(account);
    }

    @PostMapping(value = "/zmrazit", consumes = "application/json")
    public void freezeAccount(@RequestBody AccountRequest request) throws Exception{
        uctyService.freezeAccount(request.getAccountId());
    }

    @PostMapping(value = "/rozmrazit", consumes = "application/json")
    public void unfreezeAccount(@RequestBody AccountRequest request) throws Exception{
        uctyService.unfreezeAccount(request.getAccountId());
    }

}
