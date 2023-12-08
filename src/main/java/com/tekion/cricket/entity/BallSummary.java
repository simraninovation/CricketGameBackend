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
@Table(name ="ballSummary")
public class BallSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;

    @Column(name="outcomeOfBall")
    String outcomeOfBall;
    @Column(name="currentOver")
    int currentOver;
    @ManyToOne
    @JoinColumn(name="matchId",referencedColumnName = "matchId",nullable = false)
    private Matches matches;

    @ManyToOne
    @JoinColumn(name="inningId",referencedColumnName = "inningId",nullable = false)
    private Innings inning;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallSummary that = (BallSummary) o;
        return currentOver == that.currentOver && Objects.equals(Id, that.Id) && Objects.equals(outcomeOfBall, that.outcomeOfBall) && Objects.equals(matches, that.matches) && Objects.equals(inning, that.inning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, outcomeOfBall, currentOver, matches, inning);
    }

    @Override
    public String toString() {
        return "BallSummary{" +
                "Id=" + Id +
                ", outcomeOfBall='" + outcomeOfBall + '\'' +
                ", currentOver=" + currentOver +
                ", matches=" + matches +
                ", inning=" + inning +
                '}';
    }
}
