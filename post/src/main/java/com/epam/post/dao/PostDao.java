package com.epam.post.dao;

import com.epam.post.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends CrudRepository<Post,Long> {
}
