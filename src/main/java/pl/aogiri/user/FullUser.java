package pl.aogiri.user;

import java.util.ArrayList;
import java.util.List;

import pl.aogiri.match.FullMatch;
import pl.aogiri.match.Match;
import pl.aogiri.team.Team;

public class FullUser extends User {
		
	private List<Team> teams = new ArrayList<>();
	
	private List<Match> matches = new ArrayList<>();

	public FullUser() {		
	}
		
	public FullUser(User user) {
		this.setId(user.getId());
		this.setLogin(user.getLogin());
//		this.setPassword(user.getPassword());
		this.setEmail(user.getEmail());
		this.setName(user.getName());
		this.setSurname(user.getSurname());
		this.setSchoolClass(user.getSchoolClass());
		this.setProfileImage(user.getProfileImage());
		this.setPerm(user.getPerm());
		this.setLastLogon(user.getLastLogon());
		this.setSteam_id(user.getSteam_id());
		this.setLol_nickname(user.getLol_nickname());
		this.setCs_nickname(user.getCs_nickname());
		this.setActivated(user.getActivated());
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	 

	

}
