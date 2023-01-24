package com.epam.post.service;

import com.epam.post.dto.PostDTO;
import com.epam.post.dto.PostDataDTO;
import com.epam.post.dto.PostTextDTO;

public interface PostService {
    PostDTO findById(long id);

    PostDTO create(PostDataDTO postDataDTO);

    void delete(long id);

    PostDTO update(long id, PostTextDTO postTextDTO);
}
