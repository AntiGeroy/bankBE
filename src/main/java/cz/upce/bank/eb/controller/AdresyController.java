package cz.upce.bank.eb.controller;

import cz.upce.bank.eb.entity.Adresy;
import cz.upce.bank.eb.service.AdresyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/adresy")
@CrossOrigin(origins = "*")
public class AdresyController {

    @Autowired
    private AdresyService adresyService;


    @PostMapping(value = "/novy")
    public Adresy addNewAdrress(@RequestBody Adresy newAddress){
        return adresyService.createNewAddress(newAddress);
    }
}
