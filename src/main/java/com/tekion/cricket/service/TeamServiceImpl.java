package com.tekion.cricket.service;

import com.tekion.cricket.models.Players;
import com.tekion.cricket.models.Team;
import com.tekion.cricket.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    List<Team> listOfTeams = new ArrayList<Team>();
    List<Players> listOfPlayers = new ArrayList<Players>();

    @Override
    public List<Team> getAllTeams() {
        listOfTeams =  teamRepository.findAll();
        return listOfTeams;
    }
    @Override
    public Team getSpecificTeamById(Long teamId) {
        Optional<Team> optionalTeam = teamRepository.findByTeamId(teamId);
        return optionalTeam.orElse(null);
    }

    @Override
    public Team getSpecificTeamByName(String teamName) {

        return teamRepository.findByTeamName(teamName);
    }
    @Override
    public Long getSpecificTeamIdByName(String teamName) {

        return teamRepository.findIdByTeamName(teamName);
    }

    @Override
    public List<Players> getTeamPlayer(Long teamId) {

        listOfPlayers = teamRepository.findPlayersByTeamId(teamId);
        return  listOfPlayers;
    }
}
