package com.tekion.cricket.controller;

import com.tekion.cricket.models.Matches;
import com.tekion.cricket.models.Players;
import com.tekion.cricket.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MatchesController {
    @Autowired
    private MatchesService matchesService;
    @PostMapping("/new/match")
    public String savePlayerDetails(@RequestBody Matches matches){
        matchesService.save(matches);
        return "Scheduled Match";
    }
   @GetMapping
}
