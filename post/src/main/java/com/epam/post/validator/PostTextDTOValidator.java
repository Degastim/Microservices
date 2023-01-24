package com.epam.post.validator;

import com.epam.post.dto.PostTextDTO;
import org.springframework.stereotype.Component;

@Component
public class PostTextDTOValidator implements DTOValidator<PostTextDTO> {
    public boolean validate(PostTextDTO postTextDTO) {
        return postTextDTO != null && postTextDTO.getText() != null;
    }
}
