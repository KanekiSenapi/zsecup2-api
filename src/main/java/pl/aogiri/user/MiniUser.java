package pl.aogiri.user;

public class MiniUser{
	
	private String name;
	
	private String surname;
	
	private String lol_nickname;
	
	private String cs_nickname;
	
	
	public MiniUser() {		
	}
	
	public MiniUser(User user) {
		this.name = user.getName();
		this.surname = user.getSurname();
		this.lol_nickname = user.getLol_nickname();
		this.cs_nickname = user.getCs_nickname();
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


	public String getLol_nickname() {
		return lol_nickname;
	}


	public void setLol_nickname(String lol_nickname) {
		this.lol_nickname = lol_nickname;
	}


	public String getCs_nickname() {
		return cs_nickname;
	}


	public void setCs_nickname(String cs_nickname) {
		this.cs_nickname = cs_nickname;
	}
	
	
	

}
