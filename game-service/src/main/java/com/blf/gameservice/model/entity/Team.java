package com.blf.gameservice.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Team extends BaseEntity {

    @JsonIgnore
    private Integer blf;

    @Transient
    private String isBlfTeam;

    private String name;
    private String address;

    @ManyToOne
    private Season season;

    @ManyToOne
    private League league;

    
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "team_member",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<Player> teamMember;


    @PostLoad
    private void setIsBlf() {
        if (blf == 1) {
            isBlfTeam = "Blf";
        } else {
            isBlfTeam = "";
        }
    }
}
