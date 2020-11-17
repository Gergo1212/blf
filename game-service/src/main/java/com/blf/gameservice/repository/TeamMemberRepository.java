package com.blf.gameservice.repository;

import com.blf.gameservice.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

    List<TeamMember> findAllByTeamSeasonId(Long seasonId);

}
