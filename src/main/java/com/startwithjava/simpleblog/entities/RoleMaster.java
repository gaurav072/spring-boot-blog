package com.startwithjava.simpleblog.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
public class RoleMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String role;
	
}
