package pl.aogiri.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.aogiri.match.Match;
import pl.aogiri.match.MatchService;
import pl.aogiri.team.TeamRepository;
import pl.aogiri.user.MiniUser;
import pl.aogiri.user.User;
import pl.aogiri.user.UserService;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private MatchService matchService;


	
	public List<Team> getAllTeams() {
		return (List<Team>) teamRepository.findAll();
	}

	public Team getTeamById(long id) {
		Team team = teamRepository.findById(id).get();		
		return team;
	}
	
	public FullTeam getFullTeam(long id) {
		FullTeam fullTeam = new FullTeam(this.getTeamById(id));
        
        fullTeam.setPlayers(this.getTeamUsers(id));
		return fullTeam;
		
	}

	public List<User> getTeamUsers(long id) {
		Team team = this.getTeamById(id);
		List<User> players = new ArrayList<>();
		
		players.add(userService.getUserById(team.getCapitanId()));
		
        long tmp = team.getPlayer2Id();
        if( tmp != 0)
        players.add(userService.getUserById(tmp));
        tmp = team.getPlayer3Id();
        if( tmp != 0)
        players.add(userService.getUserById(tmp));
        tmp = team.getPlayer4Id();
        if( tmp != 0)
        players.add(userService.getUserById(tmp));
        tmp = team.getPlayer5Id();
        if( tmp != 0)
        players.add(userService.getUserById(tmp));
        
        return players;
	}

	public List<Team> getUserTeams(long id){
		Iterable<Team> all = this.getAllTeams();
		List<Team> teams = new ArrayList<>();
		for(Team team : all) {
			if(team.getCapitanId() == id) teams.add(team);
			else if(team.getPlayer2Id() == id) teams.add(team);
			else if(team.getPlayer3Id() == id) teams.add(team);
			else if(team.getPlayer4Id() == id) teams.add(team);
			else if(team.getPlayer5Id() == id) teams.add(team);
		}
		return teams;
	}

	public List<Match> getTeamMatches(long id) {
		return matchService.getTeamMatches(id);
	}

	public MobileTeam getMobileTeam(Map<String, String> mapped) {
		long teamID = Long.valueOf(mapped.get("teamID"));
		
		Team team = teamRepository.findById(teamID).get();
		
		MobileTeam mobileTeam = new MobileTeam(team);
		List<MiniUser> tmp = new ArrayList<>();		
		tmp.add(new MiniUser(userService.getUserById(team.getCapitanId())));
		tmp.add(new MiniUser(userService.getUserById(team.getPlayer2Id())));
		tmp.add(new MiniUser(userService.getUserById(team.getPlayer3Id())));
		tmp.add(new MiniUser(userService.getUserById(team.getPlayer4Id())));
		tmp.add(new MiniUser(userService.getUserById(team.getPlayer5Id())));		
		mobileTeam.setPlayers(tmp);
		
		
		mobileTeam.setMatches(matchService.getMatchesMobileByTeamID(teamID));
		
		return mobileTeam;
	}

}
