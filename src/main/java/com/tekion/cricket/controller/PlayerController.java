package com.tekion.cricket.controller;

import com.tekion.cricket.models.Players;
import com.tekion.cricket.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PlayerController {

   // @Autowired
    private PlayerService playerService;

    @PostMapping("/new/player")
    public String savePlayerDetails(@RequestBody Players players){
        playerService.save(players);
        return "Successfully Added Player";
    }
    @GetMapping("/player/{id}")
    @ResponseBody
    public Players getPlayerById(@PathVariable("id") Long Id){
        return playerService.getPlayerById(Id);
    }

    @GetMapping("/team/{teamId}/players")
    @ResponseBody
    public List<Players> getTeamPlayer(@PathVariable  Long teamId){
        List<Players> listOfPlayers = playerService.getTeamPlayer(teamId);
        return listOfPlayers;
    }




}
