package com.epam.post.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private Long authorId;
    private String text;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate postedAt;
}
