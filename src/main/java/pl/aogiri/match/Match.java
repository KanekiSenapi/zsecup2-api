package pl.aogiri.match;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="\"player-teams-matches\"")
public class Match {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String game;
	
	@NotNull
	@Column(name = "team1_id")
	private long team1Id;
	
	@NotNull
	@Column(name = "team2_id")
	private long team2Id;
	
	@Transient
	private String team1Tag;
	
	@Transient
	private String team2Tag;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	@NotNull
	private Timestamp date;
	
	@NotNull
	private String ipkey;
	
	@NotNull
	private String yt_link;
	
	@NotNull
	private boolean done;
	
	@NotNull
	private int bo;
	
	@NotNull
	@Column(name="team1_score")
	private int team1Score;
	
	@NotNull
	@Column(name="team2_score")
	private int team2Score;


	public Match() {
	}
	
	public Match(long id, @NotNull String game, @NotNull long team1Id, @NotNull long team2Id, @NotNull @NotNull Timestamp date,
			@NotNull String ipkey, @NotNull String yt_link, @NotNull boolean done, @NotNull int bo,
			@NotNull int team1Score, @NotNull int team2Score) {
		super();
		this.id = id;
		this.game = game;
		this.team1Id = team1Id;
		this.team2Id = team2Id;
		this.date = date;
		this.ipkey = ipkey;
		this.yt_link = yt_link;
		this.done = done;
		this.bo = bo;
		this.team1Score = team1Score;
		this.team2Score = team2Score;
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

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getIpkey() {
		return ipkey;
	}

	public void setIpkey(String ipkey) {
		this.ipkey = ipkey;
	}

	public String getYt_link() {
		return yt_link;
	}

	public void setYt_link(String yt_link) {
		this.yt_link = yt_link;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	

	public int getBo() {
		return bo;
	}

	public void setBo(int bo) {
		this.bo = bo;
	}

	public int getTeam1Score() {
		return team1Score;
	}

	public void setTeam1Score(int team1Score) {
		this.team1Score = team1Score;
	}

	public int getTeam2Score() {
		return team2Score;
	}

	public void setTeam2Score(int team2Score) {
		this.team2Score = team2Score;
	}

	public String getTeam1Tag() {
		return team1Tag;
	}

	public void setTeam1Tag(String team1Tag) {
		this.team1Tag = team1Tag;
	}

	public String getTeam2Tag() {
		return team2Tag;
	}

	public void setTeam2Tag(String team2Tag) {
		this.team2Tag = team2Tag;
	}
	
	 
	
	

	
}
