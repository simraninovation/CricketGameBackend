package com.tekion.cricket.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Matches")
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     Long matchId;
//    @Column(name="teamA_id", nullable = false)
//    int teamAid;
//    @Column(name="teamBid", nullable=false)
//    int teamBid;
    @Column(name="teamIdWonToss")
    Long teamIdWonToss ;

    @Column(name="matchOver")
    Long matchOver;
    @Column(name="umpire")
    String umpire;
    @Column(name="teamIdWhoWonMatch")
    Long  teamIdWhoWonMatch;

    @OneToOne
    @JoinColumn(name = "teamAid",referencedColumnName = "teamId", insertable = false, updatable = false)
    private Team teamA;

    @OneToOne
    @JoinColumn(name ="teamBid" ,referencedColumnName = "teamId",insertable = false, updatable = false)
    private Team teamB;

    @OneToOne(mappedBy = "matches")
    private Toss toss;
    //schedulesId integer
    @OneToMany(mappedBy="matches")
    private List<Scoreboard> scoreboardList;
}
