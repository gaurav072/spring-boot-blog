package com.startwithjava.simpleblog.entities;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment extends AbstractEntity{
	private String comment;
	private int rating;
	@ManyToOne
	@JoinColumn(name="author_id")
	private User author;
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster status;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public StatusMaster getStatus() {
		return status;
	}
	public void setStatus(StatusMaster status) {
		this.status = status;
	}	
}