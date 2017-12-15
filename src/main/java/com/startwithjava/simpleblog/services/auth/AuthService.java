package com.startwithjava.simpleblog.services.auth;

import com.startwithjava.simpleblog.entities.User;

public interface AuthService {
  public User findUserByEmail(String email);
}
