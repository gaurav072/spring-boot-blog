package com.startwithjava.simpleblog.services;

import java.util.List;

import com.startwithjava.simpleblog.entities.Post;

public interface PostService {
	public List<Post> findAll();
	public Post findById(Long id);
	public Long saveOrUpdate();
}
