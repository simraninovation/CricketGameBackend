package com.tekion.cricket.controller;

import com.tekion.cricket.models.Players;
import com.tekion.cricket.models.Team;

import com.tekion.cricket.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;
    List<Players> lisOfPlayers = new ArrayList<>();
    @GetMapping("/teams")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/team")
    public Team getAllTeams(@PathVariable String teamName){
        return teamService.getSpecificTeamByName(teamName);
    }
    @GetMapping("/teams/{teamId}")
    public Team getSpecificTeamById(@PathVariable Long teamId) {
        return teamService.getSpecificTeamById(teamId);
    }

    @GetMapping("/team/{teamId}/players")
    @ResponseBody
    public List<Players> getTeamPlayer(@PathVariable  Long teamId){
        List<Players> listOfPlayers = teamService.getTeamPlayer(teamId);
        return listOfPlayers;
    }


    @GetMapping("/specific-team")
    public Long getSpecificTeamIdByName(@RequestParam(value = "name") String teamName) {
        return teamService.getSpecificTeamIdByName(teamName);
    }
}
