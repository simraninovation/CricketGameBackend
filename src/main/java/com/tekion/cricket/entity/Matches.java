package com.tekion.cricket.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Matches")
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Long matchId;

    @Column(name="teamIdWonToss")
    Long teamIdWonToss ;

    @Column(name="matchOver")
    Long matchOver;

    @Column(name="umpire")
    String umpire;

    @Column(name="teamIdWhoWonMatch")
    Long  teamIdWhoWonMatch;

    @ManyToOne
    @JoinColumn(name = "teamAid",referencedColumnName = "teamId",updatable = false)
    private Team teamA;

    @OneToOne
    @JoinColumn(name ="teamBid" ,referencedColumnName = "teamId",updatable = false)
    private Team teamB;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matches matches = (Matches) o;
        return Objects.equals(matchId, matches.matchId) && Objects.equals(teamIdWonToss, matches.teamIdWonToss) && Objects.equals(matchOver, matches.matchOver) && Objects.equals(umpire, matches.umpire) && Objects.equals(teamIdWhoWonMatch, matches.teamIdWhoWonMatch) && Objects.equals(teamA, matches.teamA) && Objects.equals(teamB, matches.teamB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchId, teamIdWonToss, matchOver, umpire, teamIdWhoWonMatch, teamA, teamB);
    }

    @Override
    public String toString() {
        return "Matches{" +
                "matchId=" + matchId +
                ", teamIdWonToss=" + teamIdWonToss +
                ", matchOver=" + matchOver +
                ", umpire='" + umpire + '\'' +
                ", teamIdWhoWonMatch=" + teamIdWhoWonMatch +
                ", teamA=" + teamA +
                ", teamB=" + teamB +
                '}';
    }
}
