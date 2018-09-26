package pl.aogiri.match;

import pl.aogiri.team.FullTeam;

public class FullMatch extends Match {

	private FullTeam team1;
	
	private FullTeam team2;
	
	public FullMatch(){		
	}
	
	public FullMatch(Match match) {
		this.setId(match.getId());
		this.setGame(match.getGame());
		this.setTeam1Id(match.getTeam1Id());
		this.setTeam2Id(match.getTeam2Id());
		this.setDate(match.getDate());
		this.setIpkey(match.getIpkey());
		this.setYt_link(match.getYt_link());
		this.setDone(match.isDone());
		this.setBo(match.getBo());
		this.setTeam1Score(match.getTeam1Score());
		this.setTeam2Score(match.getTeam2Score());
	}
	
	public void setTeam1(FullTeam team){
		this.team1 = team;
	}
	
	public void setTeam2(FullTeam team){
		this.team2 = team;
	}
	
	public FullTeam getTeam1(){
		return this.team1;
	}
	public FullTeam getTeam2(){
		return this.team2;
	}
	
}
