package pl.aogiri.mobile.token;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mobileToken")
public class Token {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private long userId;
	
	@NotNull
	private String token;
	
	@NotNull
	private String name;
	
	@NotNull
	private int status;
	
	private String image;
	
	
	public Token() {
	}
	
	public Token(long id, @NotNull long userId, @NotNull String token, @NotNull String name, @NotNull int status, String image) {
		super();
		this.id = id;
		this.userId = userId;
		this.token = token;
		this.name = name;
		this.status = status;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
	
	

}
