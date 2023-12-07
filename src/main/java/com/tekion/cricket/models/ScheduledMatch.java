package com.tekion.cricket.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
}
