package com.tekion.cricket;

import com.tekion.cricket.dto.matchrequest.NewMatchDto;
import com.tekion.cricket.service.MatchesServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CricketApplication {

    public static void main(String[] args) {
        SpringApplication.run(CricketApplication.class, args);
    }

}
