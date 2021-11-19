package cz.upce.bank.eb.controller;

import cz.upce.bank.eb.entity.Klienti;
import cz.upce.bank.eb.service.KlientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/klienti")
@CrossOrigin(origins = "*")
public class KlientiController {

    @Autowired
    private KlientiService klientiService;

    @GetMapping("/{clientId}")
    public @ResponseBody
    Klienti getClient(@PathVariable("clientId") Integer clientId) {
        return klientiService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public @ResponseBody
    Klienti updateClient(@PathVariable("clientId") Integer clientId, @RequestBody Klienti clientData){
        return klientiService.updateClient(clientId, clientData);
    }
}
