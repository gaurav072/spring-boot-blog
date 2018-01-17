package com.startwithjava.simpleblog.services.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.startwithjava.simpleblog.entities.User;
import com.startwithjava.simpleblog.repositories.UserRepository;
/**
 * For Authentication & Authorization
 * @author Gaurav
 *
 */
@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	UserRepository userRepository;
	@Override
	public User authticate(String email,String password) {
		return userRepository.findUserByEmailAndPassword(email, password);
	}
}
