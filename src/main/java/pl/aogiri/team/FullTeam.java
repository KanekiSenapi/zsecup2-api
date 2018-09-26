package pl.aogiri.team;

import java.util.List;

import pl.aogiri.user.User;

public class FullTeam extends Team{
	
	private List<User> players;
	
	public FullTeam() {
	}
	
	public FullTeam(Team team) {
		this.setId(team.getId());
		this.setCapitanId(team.getCapitanId());
		this.setPlayer2Id(team.getPlayer2Id());
		this.setPlayer3Id(team.getPlayer3Id());
		this.setPlayer4Id(team.getPlayer4Id());
		this.setPlayer5Id(team.getPlayer5Id());
		this.setName(team.getName());
		this.setTag(team.getTag());
		this.setDescription(team.getDescription());
		this.setImage(team.getImage());
		this.setState(team.getState());
		this.setGame(team.getGame());
	}

	public List<User> getPlayers() {
		return players;
	}

	public void setPlayers(List<User> players) {
		this.players = players;
	}

	
}
