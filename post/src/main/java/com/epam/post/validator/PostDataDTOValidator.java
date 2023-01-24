package com.epam.post.validator;

import com.epam.post.dto.PostDataDTO;
import org.springframework.stereotype.Component;

@Component
public class PostDataDTOValidator implements DTOValidator<PostDataDTO> {
    public boolean validate(PostDataDTO postDataDTO) {
        return postDataDTO != null && postDataDTO.getText() != null && postDataDTO.getAuthorId() != null;
    }
}
