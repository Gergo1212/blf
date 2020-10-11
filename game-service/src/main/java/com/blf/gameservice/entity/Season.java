package com.blf.gameservice.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String date;

    @OneToMany( mappedBy = "season")
    @JsonBackReference
    Set<League> league;
}
