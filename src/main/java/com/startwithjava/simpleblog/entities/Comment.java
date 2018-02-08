package com.startwithjava.simpleblog.entities;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Comment extends AbstractEntity{
	private String comment;
	private int rating;
	@ManyToOne
	@JoinColumn(name="author_id")
	private User author;
	@ManyToOne
	@JoinColumn(name="status")
	private StatusMaster status;
}