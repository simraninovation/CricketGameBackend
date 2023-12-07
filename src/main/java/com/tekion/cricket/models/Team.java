package com.tekion.cricket.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long teamId;
    @Column(name = "teamName")
    private String teamName;
    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy="team")
    private Set<Players> player;

    @OneToOne(mappedBy = "teamA", cascade = CascadeType.ALL)
    private Matches matchesA;
    @OneToOne(mappedBy = "teamB", cascade = CascadeType.ALL)
    private Matches matchesB;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamId, team.teamId) && Objects.equals(teamName, team.teamName) && Objects.equals(country, team.country) && Objects.equals(player, team.player) && Objects.equals(matchesA, team.matchesA) && Objects.equals(matchesB, team.matchesB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, teamName, country, player, matchesA, matchesB);
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", country='" + country + '\'' +
                ", player=" + player +
                ", matchesA=" + matchesA +
                ", matchesB=" + matchesB +
                '}';
    }
}
