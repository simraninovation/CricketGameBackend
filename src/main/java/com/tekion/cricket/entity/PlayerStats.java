package com.tekion.cricket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="PlayerStats")
public class PlayerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long playerStatsId;

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

    @OneToOne
    @JoinColumn(name="playerId")
    private Players players;

    @ManyToOne
    @JoinColumn(name="matchId", nullable = false)
    private Matches matches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStats that = (PlayerStats) o;
        return runScored == that.runScored && runsGiven == that.runsGiven && overIsBowled == that.overIsBowled && ballIsBowled == that.ballIsBowled && noOfWideBalls == that.noOfWideBalls && noOfBalls == that.noOfBalls && ballIsFaced == that.ballIsFaced && wicketTaken == that.wicketTaken && playingStatus == that.playingStatus && Objects.equals(playerStatsId, that.playerStatsId) && Objects.equals(players, that.players) && Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerStatsId, runScored, runsGiven, overIsBowled, ballIsBowled, noOfWideBalls, noOfBalls, ballIsFaced, wicketTaken, playingStatus, players, matches);
    }

    @Override
    public String toString() {
        return "PlayerStats{" +
                "playerStatsId=" + playerStatsId +
                ", runScored=" + runScored +
                ", runsGiven=" + runsGiven +
                ", overIsBowled=" + overIsBowled +
                ", ballIsBowled=" + ballIsBowled +
                ", noOfWideBalls=" + noOfWideBalls +
                ", noOfBalls=" + noOfBalls +
                ", ballIsFaced=" + ballIsFaced +
                ", wicketTaken=" + wicketTaken +
                ", playingStatus=" + playingStatus +
                ", players=" + players +
                ", matches=" + matches +
                '}';
    }
}
