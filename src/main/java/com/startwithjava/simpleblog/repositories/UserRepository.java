package com.startwithjava.simpleblog.repositories;

import java.util.List;
import org.springframework.data.repository.Repository;
import com.startwithjava.simpleblog.entities.User;
public interface UserRepository extends Repository<User, Long> {
	public List<User> findUserByRoles(String username,String password);
	public User findUserByEmailAndPassword(String email,String password);
	public User findUserByEmail(String email);
}
