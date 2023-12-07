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
@Table(name ="ballSummary")
public class ballSummary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    //matchId integer
    @Column(name="outcomeOfBall")
    String outcomeOfBall;





    //matchId integer
    //inningsId integer [primary key]

    //currentOver integer [primary key]
}
