package com.tekion.cricket.service;

import com.tekion.cricket.models.Matches;
import com.tekion.cricket.models.Players;
import com.tekion.cricket.repository.MatchesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchesServiceImpl implements MatchesService{
    @Autowired
    private MatchesRepository matchesRepository;
    @Autowired
    private TossService tossService;

    @Override
    public void performMatch() {
        Matches match = new Matches();
        matchesRepository.save(match);
    }
    @Override
    public void save(Matches matches) {
        matchesRepository.save(matches);
    }

}
