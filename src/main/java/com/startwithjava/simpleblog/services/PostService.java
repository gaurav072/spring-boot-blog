package com.startwithjava.simpleblog.services;

import java.util.List;

import com.startwithjava.simpleblog.entities.Post;

public interface PostService {
	public List<Post> findPostsByCriteria();
}
