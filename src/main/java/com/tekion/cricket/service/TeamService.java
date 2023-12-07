package com.tekion.cricket.service;

import com.tekion.cricket.models.Players;
import com.tekion.cricket.models.Team;

import java.util.List;

public interface TeamService {
    List<Team> getAllTeams();

    Team getSpecificTeamById(Long teamId);

    Team getSpecificTeamByName(String teamName);

    Long getSpecificTeamIdByName(String teamName);
    List<Players> getTeamPlayer(Long teamId);
}
