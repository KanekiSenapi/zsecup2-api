package pl.aogiri.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.aogiri.match.FullMatch;
import pl.aogiri.match.Match;
import pl.aogiri.match.MatchService;
import pl.aogiri.mobile.token.TokenService;
import pl.aogiri.team.Team;
import pl.aogiri.team.TeamService;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MatchService matchService;
	
	@Autowired TokenService tokenService;
	
	public List<User> getAll() {
			List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	public User getUserById(Long id) {
		return userRepository.findUserById(id);
	}

	public Team getTeamByUserId(long id) {
		return teamService.getTeamById(id);
	}

	public FullUser getFullUser(long id) {
		List<Match> matches = new ArrayList<>();
		FullUser fullUser = new FullUser(userRepository.findById(id).get());
		
		fullUser.setTeams(teamService.getUserTeams(id));	
		
		fullUser.getTeams().forEach(team->
		matches.addAll(matchService.getTeamMatches(team.getId())));
		fullUser.setMatches(matches);
		
		return fullUser;
	}

	public boolean activateUser(long id) {
		User user = this.getUserById(id);
		user.setPerm(2);
		try{
			userRepository.save(user);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}

	public String activatedUser(long id) {
		User user = this.getUserById(id);
		String returned = "{\"email\" : \"" +user.getEmail()+"\", \"id\" : " + user.getId() + "}";
		return returned;
	}

	public User getUserByToken(Map<String, String> mapped) {
		long uid = tokenService.getUserIdByToken(mapped.get("token"));
		if(uid == 0L) return null;
		User user = this.getUserById(uid);
		return user;
	}
	
	public FullUser getFullUserByToken(String token) {
		long uid = tokenService.getUserIdByToken(token);
		if(uid == 0L) return null;
		return this.getFullUser(uid);
	}

	
	
	
}
