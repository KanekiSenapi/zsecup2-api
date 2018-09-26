package pl.aogiri.team;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="\"player-teams\"")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String game;

	@NotNull
	@Column(name = "capitan_id")
	private long capitanId;
	
	@NotNull
	@Column(name = "player2_id")
	private long player2Id;
	
	@NotNull
	@Column(name = "player3_id")
	private long player3Id;
	
	@NotNull
	@Column(name = "player4_id")
	private long player4Id;
	
	@NotNull
	@Column(name = "player5_id")
	private long player5Id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String tag;
	
	private String description;
	
	private String image;
	
	@NotNull
	private int state;	
	
	public Team() {
	}
	
	

	public Team(long id, @NotNull String game, @NotNull long capitanId, @NotNull long player2Id,
			@NotNull long player3Id, @NotNull long player4Id, @NotNull long player5Id, @NotNull String name,
			@NotNull String tag, String description, String image, @NotNull int state) {
		super();
		this.id = id;
		this.game = game;
		this.capitanId = capitanId;
		this.player2Id = player2Id;
		this.player3Id = player3Id;
		this.player4Id = player4Id;
		this.player5Id = player5Id;
		this.name = name;
		this.tag = tag;
		this.description = description;
		this.image = image;
		this.state = state;
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

	public long getCapitanId() {
		return capitanId;
	}

	public void setCapitanId(long capitanId) {
		this.capitanId = capitanId;
	}

	public long getPlayer2Id() {
		return player2Id;
	}

	public void setPlayer2Id(long player2Id) {
		this.player2Id = player2Id;
	}

	public long getPlayer3Id() {
		return player3Id;
	}

	public void setPlayer3Id(long player3Id) {
		this.player3Id = player3Id;
	}

	public long getPlayer4Id() {
		return player4Id;
	}

	public void setPlayer4Id(long player4Id) {
		this.player4Id = player4Id;
	}

	public long getPlayer5Id() {
		return player5Id;
	}

	public void setPlayer5Id(long player5Id) {
		this.player5Id = player5Id;
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

}
