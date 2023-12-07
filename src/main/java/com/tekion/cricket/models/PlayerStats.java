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
@Table(name ="PlayerStats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    //matchId integer
    @Column(name="runScored ")
    int runScored ;
    @Column(name="runsGiven")
    int runsGiven;
    @Column(name="overIsbBowled ")
    int overIsBowled;
    @Column(name="ballIsBowled")
    int ballIsBowled;
    @Column(name="noOfWideBalls")
    int noOfWideBalls;
    @Column(name="noOfBalls")
    int noOfBalls;
    @Column(name="ballIsFaced ")
    int ballIsFaced ;
    @Column(name="wicketTaken")
    int wicketTaken;
    @Column(name="playingStatus")
    boolean playingStatus;

    //playerId integer
    //matchId integer


}
