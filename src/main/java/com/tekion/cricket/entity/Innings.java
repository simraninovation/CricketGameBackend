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
public class Innings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long inningId;

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

    @ManyToOne
    @JoinColumn(name="matchId",referencedColumnName = "matchId",nullable = false)
    private Matches matches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Innings innings = (Innings) o;
        return Objects.equals(inningId, innings.inningId) && Objects.equals(battingTeamId, innings.battingTeamId) && Objects.equals(ballingTeamId, innings.ballingTeamId) && Objects.equals(totalScore, innings.totalScore) && Objects.equals(wicketsFallen, innings.wicketsFallen) && Objects.equals(extraRuns, innings.extraRuns) && Objects.equals(noOfNoBalls, innings.noOfNoBalls) && Objects.equals(noOfWideBalls, innings.noOfWideBalls) && Objects.equals(innStatus, innings.innStatus) && Objects.equals(matches, innings.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inningId, battingTeamId, ballingTeamId, totalScore, wicketsFallen, extraRuns, noOfNoBalls, noOfWideBalls, innStatus, matches);
    }

    @Override
    public String toString() {
        return "Innings{" +
                "inningId=" + inningId +
                ", battingTeamId=" + battingTeamId +
                ", ballingTeamId=" + ballingTeamId +
                ", totalScore=" + totalScore +
                ", wicketsFallen=" + wicketsFallen +
                ", extraRuns=" + extraRuns +
                ", noOfNoBalls=" + noOfNoBalls +
                ", noOfWideBalls=" + noOfWideBalls +
                ", innStatus=" + innStatus +
                ", matches=" + matches +
                '}';
    }
}
