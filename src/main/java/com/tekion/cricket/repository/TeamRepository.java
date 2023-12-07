package com.tekion.cricket.repository;

import com.tekion.cricket.models.Players;
import com.tekion.cricket.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findAll();
    @Query("SELECT t FROM Team t WHERE t.teamId = :teamId")
    Optional<Team> findByTeamId(@Param("teamId") Long teamId);
    Team findByTeamName(String teamName);
    Long findIdByTeamName(String teamName);
    List<Players> findPlayersByTeamId(Long teamId);


}
