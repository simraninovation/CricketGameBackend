package com.tekion.cricket.repository;

import com.tekion.cricket.models.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository  extends JpaRepository<Players, Long> {
    List<Players> findPlayersByTeamTeamId(long teamId);

    Optional<Players> findById(Long Id);
}
