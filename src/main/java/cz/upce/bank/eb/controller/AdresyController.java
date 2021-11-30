package cz.upce.bank.eb.controller;

import cz.upce.bank.eb.entity.Adresy;
import cz.upce.bank.eb.entity.Klienti;
import cz.upce.bank.eb.service.AdresyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/adresy")
@CrossOrigin(origins = "*")
public class AdresyController {

    @Autowired
    private AdresyService adresyService;


    @PostMapping(value = "/novy")
    public Adresy addNewAdrress(@RequestBody Adresy newAddress) throws SQLException {
        return adresyService.createNewAddress(newAddress);
    }

    @GetMapping("/{addressId}")
    public @ResponseBody
    Adresy getAddress(@PathVariable("addressId") Integer addressId){
        return adresyService.getAddressById(addressId);
    }

    @PutMapping("/{addressId}")
    public @ResponseBody
    Adresy updateAddress(@PathVariable("addressId") Integer addressId, @RequestBody Adresy addressData){
        return adresyService.updateAddress(addressId, addressData);
    }

}
