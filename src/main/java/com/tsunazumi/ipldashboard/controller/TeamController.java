package com.tsunazumi.ipldashboard.controller;

import com.tsunazumi.ipldashboard.model.Match;
import com.tsunazumi.ipldashboard.model.Team;
import com.tsunazumi.ipldashboard.repository.MatchRepository;
import com.tsunazumi.ipldashboard.repository.TeamRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

  @GetMapping("/team/{teamName}/matches")
  public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
    LocalDate startDate = LocalDate.of(year, 1, 1);
    LocalDate endDate = LocalDate.of(year + 1, 1, 1);
    return this.matchRepository.getMatchesByTeamBetweenDates(teamName, startDate, endDate);
  }

}
