package com.tekion.cricket.service;

import com.tekion.cricket.models.Matches;
import com.tekion.cricket.models.Players;

public interface MatchesService {
    void save(Matches matches);
    void performMatch();

}
