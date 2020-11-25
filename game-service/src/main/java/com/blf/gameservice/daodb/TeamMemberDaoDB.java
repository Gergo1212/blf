package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.TeamMemberDao;
import com.blf.gameservice.entity.TeamMember;
import com.blf.gameservice.repository.TeamMemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamMemberDaoDB implements TeamMemberDao {

    private final TeamMemberRepository teamMemberRepository;

    @Override
    public List<TeamMember> getAllTeamMembers() {
        int limiter = 30;
        return teamMemberRepository.findAll().stream().limit(limiter).collect(Collectors.toList());
    }

    @Override
    public List<TeamMember> getAllTeamMembersBySeasonId(Long seasonId) {
        return teamMemberRepository.findAllByTeamSeasonIdOrderByTeam(seasonId);
    }
}
