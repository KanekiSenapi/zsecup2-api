package pl.aogiri.match;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.aogiri.team.Team;
import pl.aogiri.team.TeamService;
import pl.aogiri.user.FullUser;
import pl.aogiri.user.UserService;

@Service
public class MatchService {
	
	@Autowired
	MatchRepository matchRepository;
		
	@Autowired
	TeamService teamService;
	
	@Autowired
	UserService userService;
	
	public List<Match> getMatches(){
		return (List<Match>) matchRepository.findAll();
		
	}

	public Match getMatch(long id) {
		Match match = matchRepository.findById(id).get();
		return match;
	}
	
	public FullMatch getFullMatch(long id) {
		FullMatch fullMatch = new FullMatch(this.getMatch(id));
		fullMatch.setTeam1(teamService.getFullTeam(fullMatch.getTeam1Id()));
		fullMatch.setTeam2(teamService.getFullTeam(fullMatch.getTeam2Id()));
		
		return fullMatch;
	}
	
	public List<Match> getTeamMatches(long id){
		List<Match> matches = new ArrayList<>();
		matches.addAll(matchRepository.findByTeam1Id(id));
		matches.addAll(matchRepository.findByTeam2Id(id));
		matches.forEach(team->{team.setTeam1Tag(teamService.getTeamById(team.getTeam1Id()).getTag()); team.setTeam2Tag(teamService.getTeamById(team.getTeam2Id()).getTag());});
		return matches;
	}
	
	public List<MatchMobile> getMobileMatchesByTeamId(long id){
		List<MatchMobile> matchMobile = new ArrayList<>();
		matchRepository.findByTeam1Id(id).forEach(match -> matchMobile.add(getMatchMobile(match.getId())));
		matchRepository.findByTeam2Id(id).forEach(match -> matchMobile.add(getMatchMobile(match.getId())));
		return matchMobile;
	}
	
	public List<FullMatch> getTeamMatchesFull(long id){
		List<FullMatch> matches = new ArrayList<>();
		this.getTeamMatches(id).forEach(match->matches.add(new FullMatch(match)));
		return matches;
	}

	public List<MatchMobile> getMatchesMobile() {
		List<MatchMobile> toReturn = new ArrayList<>();
		matchRepository.findAll().forEach( match ->{						
			toReturn.add(this.getMatchMobile(match.getId()));
		});

		return toReturn;
	}
	
	public MatchMobile getMatchMobile(long id) {
		Match match = this.getMatch(id);
		MatchMobile matchMobile = new MatchMobile(match);
		Team team1 = teamService.getTeamById(match.getTeam1Id());
		Team team2 = teamService.getTeamById(match.getTeam2Id());
		matchMobile.setTeam2Logo(team2.getImage());
		matchMobile.setTeam2Name(team2.getName());
		matchMobile.setTeam1Logo(team1.getImage());
		matchMobile.setTeam1Name(team1.getName());
		return matchMobile;		
	}
	
	public List<MatchMobile> getMatchesMobileByTeamID(long id){
		List<MatchMobile> matchesMobile = getMobileMatchesByTeamId(id);					
		return matchesMobile;
	}

	public List<MatchMobile> getUsersMatch(String token) {
		FullUser fullUser = userService.getFullUserByToken(token);
		List<MatchMobile> matches = new ArrayList<>();
		fullUser.getMatches().forEach(match -> matches.add(this.getMatchMobile(match.getId())));
		return matches;
	}
	
	
	



}
