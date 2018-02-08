package com.startwithjava.simpleblog.entities;
import lombok.Data;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
@Entity
@Data
public class User extends AbstractEntity{
	private String email;
	private String username;
	private String password;
	private String name;
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<RoleMaster> roles;
	private short status;
}
