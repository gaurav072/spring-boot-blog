package com.startwithjava.simpleblog.repositories;

import java.util.List;
import org.springframework.data.repository.Repository;
import com.startwithjava.simpleblog.entities.User;

public interface UserRepository extends Repository<User, Long> {
	public User findUserByUsernameAndPassword(String username,String password);
	public List<User> findUserByRoles(String username,String password);
	public User findUserByEmail(String email);
}
