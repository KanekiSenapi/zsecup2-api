package pl.aogiri.news;

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
@Table(name="news")
public class News {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Warsaw")
	@NotNull
	@Column(name="creation_date")
	private Timestamp creationDate;
	
	@NotNull
	private String tags;
	
	@NotNull
	private String title;
	
	@NotNull
	private String body;
	
	@NotNull
	private String image;
	
	@NotNull
	@Column(name="creator_id")
	private long creatorId;
	
	@NotNull
	private int visible;

	public News() {
	}
	
	public News(long id, @NotNull Timestamp creationDate, @NotNull String tags, @NotNull String title,
			@NotNull String body, @NotNull String image, @NotNull long creatorId, @NotNull int visible) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.tags = tags;
		this.title = title;
		this.body = body;
		this.image = image;
		this.creatorId = creatorId;
		this.visible = visible;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(long creatorId) {
		this.creatorId = creatorId;
	}

	public int getVisible() {
		return visible;
	}

	public void setVisible(int visible) {
		this.visible = visible;
	}
	
	
	
	
}
