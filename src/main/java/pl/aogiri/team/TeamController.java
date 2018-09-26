package pl.aogiri.team;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.aogiri.match.Match;
import pl.aogiri.user.User;

@RestController
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/teams")
	public List<Team> getAllTeams(){
		return teamService.getAllTeams();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/team/{id}")
	public Team getTeamById(@PathVariable long id) {
		return teamService.getTeamById(id);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/team/{id}/full")
	public FullTeam getFullTeam(@PathVariable long id) {
		return teamService.getFullTeam(id);		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/team/{id}/users")
	public List<User> getTeamUsersById(@PathVariable long id){
		return teamService.getTeamUsers(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/team/{id}/matches")
	public List<Match> getTeamMatches(@PathVariable long id){
		return teamService.getTeamMatches(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/team")
	public MobileTeam getMobileTeam(@RequestBody Map<String, String> mapped){
		return teamService.getMobileTeam(mapped);		
	}
	
}
