package cz.upce.bank.eb.controller;

import cz.upce.bank.eb.entity.Uvery;
import cz.upce.bank.eb.service.UveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/uvery")
@CrossOrigin(origins = "*")
public class UveryController {

    @Autowired
    UveryService uveryService;

    @GetMapping("/{creditId}")
    public @ResponseBody
    Uvery getUver(@PathVariable("creditId") Integer creditId) { return uveryService.getUver(creditId); }

    @PutMapping("/{creditId}")
    public @ResponseBody
    Uvery updateUver(@PathVariable("creditId") Integer uverId, @RequestBody Uvery uverData){
        return uveryService.updateUver(uverId, uverData);
    }
}
