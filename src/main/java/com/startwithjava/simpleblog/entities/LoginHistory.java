package com.startwithjava.simpleblog.entities;

import lombok.Data;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="login_history")
@Data
public class LoginHistory extends AbstractEntity {
	private String message;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private short status;
}
