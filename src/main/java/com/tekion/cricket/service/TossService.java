package com.tekion.cricket.service;

import com.tekion.cricket.enums.TossResult;

public interface TossService {
    boolean performToss(Long matchId, Long TeamAid, long TeamBid);
}
