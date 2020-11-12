package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.TeamMemberDao;
import com.blf.gameservice.entity.TeamMember;
import com.blf.gameservice.repository.TeamMemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TeamMemberDaoDB implements TeamMemberDao {

    TeamMemberRepository teamMemberRepository;

    @Override
    public List<TeamMember> getAllTeamMembers() {
        return teamMemberRepository.findAll();
    }
}
