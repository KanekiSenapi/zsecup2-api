package pl.aogiri.match;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
	
	@Autowired
	MatchService matchService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/matches")
	public List<Match> getMatches() {
		return matchService.getMatches();
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/match/{id}")
	public Match getMatch(@PathVariable long id) {
		return matchService.getMatch(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/match/{id}/full")
	public Match getFullMatch(@PathVariable long id) {
		return matchService.getFullMatch(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/api/matches")
	public List<MatchMobile> getMatchesMobile() {
		return matchService.getMatchesMobile();
	}
	
	@RequestMapping(method = RequestMethod.POST, value= "/api/match")
	public MatchMobile getMatchesMobile(@RequestBody Map<String, String> mapped) {
		long id = Long.valueOf(mapped.get("matchID"));
		return matchService.getMatchMobile(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/match/user")
	public List<MatchMobile> getUserMatchesMobile(@RequestBody Map<String, String> body){
		return matchService.getUsersMatch(body.get("token"));
	}
	

}
