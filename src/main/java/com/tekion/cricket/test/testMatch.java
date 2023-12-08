package com.tekion.cricket.test;


import com.tekion.cricket.controller.MatchesController;
import com.tekion.cricket.dto.matchrequest.NewMatchDto;
import com.tekion.cricket.service.MatchesServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class testMatch {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        String nameA = "", nameB = "";
        int matchOvers = 0;
        System.out.println("Enter TeamA Name: ");

        try {
            nameA = sc.nextLine();
            if (nameA.length() <= 0)
                throw new Exception("Please Enter a valid Team Name !!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Enter TeamB Name: ");
        try {
            nameB = sc.nextLine();
            if (nameB.length() <= 0) {
                throw new Exception("Please Enter a valid Team Name !!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        NewMatchDto matches = new NewMatchDto();
        matches.setMatchId(1L);
        matches.setTeamA(1L);
        matches.setTeamB(2L);
        matches.setMatchOvers(20);
        MatchesServiceImpl matchController = new MatchesServiceImpl();

        matchController.playTheMatch(matches);
    }
}
