package com.tekion.cricket.controller;

import com.tekion.cricket.service.TossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/toss")
public class TossController {
    @Autowired
    private TossService tossService;
    @GetMapping("/perform/toss/{matchId}/{TeamAid}/{TeamBid}")
    public ResponseEntity<Boolean> performToss(@PathVariable Long matchId, Long TeamAid, Long TeamBid ) {
        boolean result = tossService.performToss(matchId,TeamAid,TeamBid);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
