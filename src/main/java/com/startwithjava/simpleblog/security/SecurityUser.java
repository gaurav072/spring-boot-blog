package com.startwithjava.simpleblog.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.startwithjava.simpleblog.entities.RoleMaster;
import com.startwithjava.simpleblog.entities.User;

public class SecurityUser extends User implements UserDetails{
private static final long serialVersionUID = 1L;

public SecurityUser(User user) {
 if(user != null)
 {
	this.setId(user.getId());
	this.setName(user.getName());
	this.setEmail(user.getEmail());
	this.setPassword(user.getPassword());
	this.setRoles(user.getRoles());
 }
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {

Collection<GrantedAuthority> authorities = new ArrayList<>();
List<RoleMaster> userRoles = this.getRoles();

if(userRoles != null)
{

for (RoleMaster role : userRoles) {

SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
authorities.add(authority);
}

}

return authorities;

}

@Override
public String getPassword() {
return super.getPassword();
}

@Override

public String getUsername() {
return super.getEmail();

}

@Override

public boolean isAccountNonExpired() {
return true;

}

@Override
public boolean isAccountNonLocked() {
return true;
}

@Override

public boolean isCredentialsNonExpired() {
return true;

}

@Override

public boolean isEnabled() {
 return true;
}

}
