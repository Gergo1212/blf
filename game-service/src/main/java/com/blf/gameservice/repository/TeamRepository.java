package com.blf.gameservice.repository;
import com.blf.gameservice.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("SELECT team FROM Team AS team WHERE team.blf = 1")
    List<Team> getAllBlfTeams();

    List<Team> findAllBySeasonId(Long seasonId);

    List<Team> findAllByNameContainingIgnoreCase(String teamName);

}
