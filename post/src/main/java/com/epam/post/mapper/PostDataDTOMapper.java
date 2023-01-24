package com.epam.post.mapper;

import com.epam.post.dto.PostDataDTO;
import com.epam.post.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostDataDTOMapper implements DTOMapper<Post,PostDataDTO> {
    @Override
    public Post toEntity(PostDataDTO dto) {
        return new Post(dto.getAuthorId(),dto.getText());
    }

    @Override
    public PostDataDTO toDTO(Post entity) {
        return new PostDataDTO(entity.getAuthorId(),entity.getText());
    }
}
