package pl.aogiri.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String login;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
	
	@NotNull
	private String name;

	@NotNull
	private String surname;
	
	@NotNull
	private String schoolClass;
	
	@NotNull
	private String profileImage;
	
	@NotNull
	private int perm;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	@NotNull
	private Timestamp lastLogon;	
	
	private String steam_id;
	
	@Column(name="lol_nickname")
	private String lolNickname;
	
	@Column(name="cs_nickname")
	private String csNickname;
	
	
	
	@NotNull
	private int activated;
	

	public User() {
	}
	
	public User(long id, @NotNull String login, @NotNull String password, @NotNull String email, @NotNull String name,
			@NotNull String surname, @NotNull String schoolClass, @NotNull String profileImage, @NotNull int perm,
			@NotNull Timestamp lastLogon, String steam_id, String lol_nickname, String cs_nickname, @NotNull int activated) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.schoolClass = schoolClass;
		this.profileImage = profileImage;
		this.perm = perm;
		this.lastLogon = lastLogon;
		this.steam_id = steam_id;
		this.lolNickname = lol_nickname;
		this.csNickname = cs_nickname;
		this.activated = activated;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public String getPassword() {
//		return password;
//	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSchoolClass() {
		return schoolClass;
	}

	public void setSchoolClass(String schoolClass) {
		this.schoolClass = schoolClass;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public int getPerm() {
		return perm;
	}

	public void setPerm(int perm) {
		this.perm = perm;
	}

	public Timestamp getLastLogon() {
		return lastLogon;
	}

	public void setLastLogon(Timestamp lastLogon) {
		this.lastLogon = lastLogon;
	}

	public String getSteam_id() {
		return steam_id;
	}

	public void setSteam_id(String steam_id) {
		this.steam_id = steam_id;
	}

	public int getActivated() {
		return activated;
	}

	public void setActivated(int activated) {
		this.activated = activated;
	}

	public String getLol_nickname() {
		return lolNickname;
	}

	public void setLol_nickname(String lol_nickname) {
		this.lolNickname = lol_nickname;
	}

	public String getCs_nickname() {
		return csNickname;
	}

	public void setCs_nickname(String cs_nickname) {
		this.csNickname = cs_nickname;
	}
	
	
}
