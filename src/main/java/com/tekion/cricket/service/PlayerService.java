package com.tekion.cricket.service;

import com.tekion.cricket.models.Players;

import java.util.List;

public interface PlayerService {
    List<Players> getTeamPlayer(Long teamId);

    void save(Players player);
    List<Players> findTeamPlayer(Long teamId);

    Players getPlayerByTeam(Long teamId);

    Players getPlayerById(Long Id);
}
