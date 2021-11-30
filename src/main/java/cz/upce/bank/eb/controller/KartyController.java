package cz.upce.bank.eb.controller;

import cz.upce.bank.eb.entity.AccountRequest;
import cz.upce.bank.eb.entity.CardRequest;
import cz.upce.bank.eb.entity.Karty;
import cz.upce.bank.eb.service.KartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/karty")
@CrossOrigin(origins = "*")
public class KartyController {

    @Autowired
    private KartyService kartyService;

    @GetMapping("/{cardId}")
    public @ResponseBody
    Karty getCard(@PathVariable("cardId") Integer cardId) {
        return kartyService.getCardById(cardId);
    }

    @PostMapping(value = "/zmrazit", consumes = "application/json")
    public void freezeCard(@RequestBody CardRequest request) throws Exception{
        kartyService.freezeCard(request.getCardId());
    }

    @PostMapping(value = "/rozmrazit", consumes = "application/json")
    public void unfreezeCard(@RequestBody CardRequest request) throws Exception{
        kartyService.unfreezeCard(request.getCardId());
    }

    @PostMapping(value = "/terminovat", consumes = "application/json")
    public void terminateCard(@RequestBody CardRequest request) throws Exception{
        kartyService.terminateCard(request.getCardId());
    }

}
