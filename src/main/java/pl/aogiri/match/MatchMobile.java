package pl.aogiri.match;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


public class MatchMobile{
		

	public long id;
	
	public String game;
	
	public long team1Id;
	public String team1Name;
	public int team1Score;
	public String team1Logo;
	
	public long team2Id;
	public String team2Name;
	public int team2Score;
	public String team2Logo;
	
	public boolean done;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	public Timestamp date;
	
	public MatchMobile() {
	}

	public MatchMobile(long id, String game, String team1Name, int team1Score, String team1Logo, String team2Name,
			int team2Score, String team2Logo, Timestamp date, boolean done) {
		super();
		this.id = id;
		this.game = game;
		this.team1Name = team1Name;
		this.team1Score = team1Score;
		this.team1Logo = team1Logo;
		this.team2Name = team2Name;
		this.team2Score = team2Score;
		this.team2Logo = team2Logo;
		this.date = date;
		this.done = done;
	}
	
	public MatchMobile(Match match) {

		this.id = match.getId();
		this.game = match.getGame();
		this.team1Score = match.getTeam2Score();
		this.team2Score = match.getTeam2Score();
		this.date = match.getDate();
		this.team1Id = match.getTeam1Id();
		this.team2Id = match.getTeam2Id();
		this.done = match.isDone();
			
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
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

	public String getTeam1Name() {
		return team1Name;
	}

	public void setTeam1Name(String team1Name) {
		this.team1Name = team1Name;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	public String getTeam1Logo() {
		return team1Logo;
	}

	public void setTeam1Logo(String team1Logo) {
		this.team1Logo = team1Logo;
	}

	public String getTeam2Name() {
		return team2Name;
	}

	public void setTeam2Name(String team2Name) {
		this.team2Name = team2Name;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}

	public String getTeam2Logo() {
		return team2Logo;
	}

	public void setTeam2Logo(String team2Logo) {
		this.team2Logo = team2Logo;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public long getTeam1Id() {
		return team1Id;
	}

	public void setTeam1Id(long team1Id) {
		this.team1Id = team1Id;
	}

	public long getTeam2Id() {
		return team2Id;
	}

	public void setTeam2Id(long team2Id) {
		this.team2Id = team2Id;
	}
	
	
	
	
	

	
	

	
	

}
