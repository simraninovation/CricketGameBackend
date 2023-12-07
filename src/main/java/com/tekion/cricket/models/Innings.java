package com.tekion.cricket.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Innings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    //matchId integer
    @Column(name="battingTeamId")
     Long battingTeamId;
    @Column(name="ballingTeamId")
    Long ballingTeamId;
    @Column(name="totalScore")
    Long totalScore;
    @Column(name="wicketsFallen")
    Long wicketsFallen;
    @Column(name="extraRuns")
    Long extraRuns;
    @Column(name="noOfNoBalls ")
    Long noOfNoBalls ;
    @Column(name="noOfWideBalls")
    Long noOfWideBalls;
    @Column(name="innStatus")
    Long innStatus;



}
