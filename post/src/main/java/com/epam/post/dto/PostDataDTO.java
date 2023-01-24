package com.epam.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDataDTO {
    private Long authorId;
    private String text;
}
