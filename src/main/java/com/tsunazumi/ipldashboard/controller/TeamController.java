package com.tsunazumi.ipldashboard.controller;

import com.tsunazumi.ipldashboard.model.Team;
import com.tsunazumi.ipldashboard.repository.MatchRepository;
import com.tsunazumi.ipldashboard.repository.TeamRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

  private TeamRepository teamRepository;
  private MatchRepository matchRepository;

  public TeamController(TeamRepository teamRepository,
                        MatchRepository matchRepository) {
    this.teamRepository = teamRepository;
    this.matchRepository = matchRepository;
  }

  @GetMapping("/team/{teamName}")
  public Team getTeam(@PathVariable String teamName) {
    Team team = teamRepository.findByTeamName(teamName);
    team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, 2));
    return team;
  }
}
