package pl.aogiri.team;

import java.util.List;

import pl.aogiri.match.MatchMobile;
import pl.aogiri.user.MiniUser;


public class MobileTeam {
	
	private long id;
	
	private String game;
	
	private String name;
	
	private String tag;
	
	private String description;
	
	private String image;
	
	private int state;
	
	private List<MiniUser> players;
	
	private List<MatchMobile> matches;
	
	public MobileTeam() {
	}
	
	public MobileTeam(Team team) {
		super();
		this.id = team.getId();
		this.game = team.getGame();
		this.name = team.getName();
		this.tag = team.getTag();
		this.description = team.getDescription();
		this.image = team.getImage();
		this.state = team.getState();
	}


	public MobileTeam(long id, String game, String name, String tag, String description, String image, int state,
			List<MiniUser> players, List<MatchMobile> matches) {
		super();
		this.id = id;
		this.game = game;
		this.name = name;
		this.tag = tag;
		this.description = description;
		this.image = image;
		this.state = state;
		this.players = players;
		this.matches = matches;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<MiniUser> getPlayers() {
		return players;
	}

	public void setPlayers(List<MiniUser> players) {
		this.players = players;
	}

	public List<MatchMobile> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchMobile> matches) {
		this.matches = matches;
	}
	
	
	
	
	
	
	

}
