package com.startwithjava.simpleblog.services.post;
import com.startwithjava.simpleblog.entities.Post;
import com.startwithjava.simpleblog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostRepository postDao;
    @Override
    public List<Post> findAll(int limit) {
        return postDao.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postDao.findOne(id);
    }

    @Override
    @Transactional
    public Long saveOrUpdate(Post entity) {
        Post post = postDao.save(entity);
        long postId = 0l;
        if(Objects.nonNull(post))
          postId =  post.getId();

        return postId;
    }
}
