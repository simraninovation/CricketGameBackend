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
@Table(name ="Scoreboard")
public class Scoreboard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long scoreboardId;

    @Column(name="zero")
    int zero;

    @Column(name="one")
    int one;

    @Column(name="two")
    int two;

    @Column(name="three")
    int three;

    @Column(name="four")
    int four;

    @Column(name="five")
    int five;

    @Column(name="six")
    int six;

    @Column(name="extraRun")
    int extraRun;

    @Column(name="wicket")
    int wicket;

    @OneToOne
    @JoinColumn(name="playerId",referencedColumnName = "Id")
    private Players players;

    @ManyToOne
    @JoinColumn(name="matchId",referencedColumnName = "matchId",nullable = false)
    private Matches matches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scoreboard that = (Scoreboard) o;
        return zero == that.zero && one == that.one && two == that.two && three == that.three && four == that.four && five == that.five && six == that.six && extraRun == that.extraRun && wicket == that.wicket && Objects.equals(scoreboardId, that.scoreboardId) && Objects.equals(players, that.players) && Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreboardId, zero, one, two, three, four, five, six, extraRun, wicket, players, matches);
    }

    @Override
    public String toString() {
        return "Scoreboard{" +
                "scoreboardId=" + scoreboardId +
                ", zero=" + zero +
                ", one=" + one +
                ", two=" + two +
                ", three=" + three +
                ", four=" + four +
                ", five=" + five +
                ", six=" + six +
                ", extraRun=" + extraRun +
                ", wicket=" + wicket +
                ", players=" + players +
                ", matches=" + matches +
                '}';
    }
}
