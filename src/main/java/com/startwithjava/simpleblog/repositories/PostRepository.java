package com.startwithjava.simpleblog.repositories;

import com.startwithjava.simpleblog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
