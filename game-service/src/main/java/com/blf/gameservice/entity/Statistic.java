package com.blf.gameservice.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Statistic {

    @GeneratedValue
    @Id
    Long id;

    Integer player_id;
    Integer played_time;

    @Column(name = "3pt_attempt")
    Integer pt3Attempt;

    @Column(name = "3pt_made")
    Integer pt3Made;

    Integer midRangeAttempt;
    Integer midRangeMade;
    Integer closeShotAttempt;
    Integer closeShotMade;
    Integer shotPercentage;
    Integer freeThrowAttempt;
    Integer freeThrowPercentage;
    Integer defensiveRebound;
    Integer offensiveRebound;
    Integer totalRebound;
    Integer steal;
    Integer turnover;
    Integer fouledAgainst;
    Integer committedFoul;
    Integer assist;
    Integer technicalMistake;
    Integer block;
    Integer ibm;
    Integer totalPts;
}
