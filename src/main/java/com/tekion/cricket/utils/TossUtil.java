package com.tekion.cricket.utils;

import com.tekion.cricket.entity.Team;
import com.tekion.cricket.entity.Toss;

import java.util.Scanner;

public class TossUtil {

    public static Toss tossUtil(Team callingTeam, Team teamB) {
        String callersChoice = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: Head or Tail " + callingTeam.getTeamName());
        System.out.println("Enter 0 for HEAD");
        System.out.println("Enter 1 for TAIL");
        int choice = sc.nextInt();

        if(choice == 0)
            callersChoice = "HEAD";
        else
            callersChoice = "TAIL";
        int outComeOnToss = (int) (Math.random() * 2);
        // I have considered 0 for head & 1 for tail
        System.out.println("Toss Outcome: " + outComeOnToss);


        System.out.println("What will you choose ?");
        System.out.println("Enter 0 for Batting");
        System.out.println("Enter 1 for Bowling");
        int selectFirst = sc.nextInt();
        if(selectFirst == 0)
            System.out.println("Winner Team chose to: Bat");
        else
            System.out.println("Winner Team chose to: Ball");

        Toss tossWnner = new Toss();
        if(outComeOnToss == choice){
            tossWnner.setTeamIdWonToss(callingTeam.getTeamId());
            tossWnner.setTossOutcome(true);
            tossWnner.setBallingTeamId(selectFirst == 1 ? callingTeam.getTeamId() : teamB.getTeamId());
            tossWnner.setBattingTeamId(selectFirst == 0 ? callingTeam.getTeamId() : teamB.getTeamId());
        } else {
            tossWnner.setTeamIdWonToss(teamB.getTeamId());
            tossWnner.setTossOutcome(false);
            tossWnner.setBallingTeamId(selectFirst == 1 ? teamB.getTeamId() : callingTeam.getTeamId());
            tossWnner.setBattingTeamId(selectFirst == 0 ? teamB.getTeamId() : callingTeam.getTeamId());
        }

        return  tossWnner;

    }

    public static Toss tossSetup(Team teamA, Team teamB) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Now will play the coin for the Toss");
        System.out.println("Please Decide who will take the call & enter 1 for "+teamA.getTeamName()+" or 2 for "+teamB.getTeamName()+" whoever will take the call");
        int call = sc.nextInt();
        // Here TeamA is considered as 0 & TeamB is considered as 1
        if (call == 1) {
             return tossUtil(teamA, teamB);
        } else {
             return tossUtil(teamB, teamA);
        }

    }
}
