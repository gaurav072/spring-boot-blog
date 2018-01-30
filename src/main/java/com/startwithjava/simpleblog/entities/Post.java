package com.startwithjava.simpleblog.entities;
import org.hibernate.annotations.MetaValue;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Post extends AbstractEntity{
	private String title;
	private String content;
	private String slug;
	private String postType;

	@ElementCollection (fetch=FetchType.EAGER)
	@CollectionTable(name="post_meta" , joinColumns=@JoinColumn(name="ID"))
	@Column(name = "meta_value",nullable = true)
	public Map<String, String> postMetas = new HashMap<>();

	@ManyToOne
	@JoinColumn(name="author_id")
	private User author;
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster status;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public StatusMaster getStatus() {
		return status;
	}
	public void setStatus(StatusMaster status) {
		this.status = status;
	}
}
