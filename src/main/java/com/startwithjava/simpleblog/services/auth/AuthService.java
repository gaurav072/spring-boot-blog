package com.startwithjava.simpleblog.services.auth;

import org.springframework.stereotype.Service;
import com.startwithjava.simpleblog.entities.User;
@Service
public interface AuthService {
  public User authticate(String email,String password);
}
