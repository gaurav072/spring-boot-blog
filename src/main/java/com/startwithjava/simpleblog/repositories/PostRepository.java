package com.startwithjava.simpleblog.repositories;

import com.startwithjava.simpleblog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Optional<Post> findOne(long id);
}
