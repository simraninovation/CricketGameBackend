package com.tekion.cricket.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="scheduleMatch")
public class ScheduledMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int scheduleMatchId;

    @Column(name="venue")
    String venue;

    @Column(name="date")
    Date date;

    @Column(name="matchStatus")
    boolean matchStatus;

    @OneToOne
    @JoinColumn(name="matchId",referencedColumnName = "matchId",nullable = false)
    private Matches matches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduledMatch that = (ScheduledMatch) o;
        return scheduleMatchId == that.scheduleMatchId && matchStatus == that.matchStatus && Objects.equals(venue, that.venue) && Objects.equals(date, that.date) && Objects.equals(matches, that.matches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleMatchId, venue, date, matchStatus, matches);
    }

    @Override
    public String toString() {
        return "ScheduledMatch{" +
                "scheduleMatchId=" + scheduleMatchId +
                ", venue='" + venue + '\'' +
                ", date=" + date +
                ", matchStatus=" + matchStatus +
                ", matches=" + matches +
                '}';
    }
}
