package com.epam.post.mapper;

import com.epam.post.dto.PostDTO;
import com.epam.post.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostDTOMapper implements DTOMapper<Post, PostDTO> {
    @Override
    public Post toEntity(PostDTO dto) {
        return new Post(dto.getId(), dto.getAuthorId(), dto.getText(), dto.getPostedAt());
    }

    @Override
    public PostDTO toDTO(Post entity) {
        return new PostDTO(entity.getId(), entity.getAuthorId(), entity.getText(), entity.getPostedAt());
    }
}
