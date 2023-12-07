package com.tekion.cricket.service;

import com.tekion.cricket.models.Players;
import com.tekion.cricket.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public  abstract class PlayerServiceImpl implements PlayerService{
    @Autowired
    private PlayerRepository playerRepository;
    List<Players> listOfPlayers = new ArrayList<Players>();
    @Override
    public List<Players> getTeamPlayer(Long teamId) {

         listOfPlayers = playerRepository.findPlayersByTeamTeamId(teamId);
         return  listOfPlayers;
    }
    @Override
    public void save(Players player) {
       playerRepository.save(player);
    }

    @Override
    public Players getPlayerById(Long Id) {
        Optional<Players> optionalPlayers = playerRepository.findById(Id);
        return optionalPlayers.orElse(null);
    }
}
