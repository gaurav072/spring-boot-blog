package com.startwithjava.simpleblog.services;

import com.startwithjava.simpleblog.entities.Post;
import com.startwithjava.simpleblog.repositories.PostDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PostServiceImpl implements PostService{
    @Autowired
    PostDao postDao;
    @Override
    public List<Post> findAll() {
        return postDao.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postDao.findOne(id);
    }

    @Override
    public Long saveOrUpdate() {

        return null;
    }
}
