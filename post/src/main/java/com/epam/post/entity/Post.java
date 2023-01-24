package com.epam.post.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "text")
    private String text;
    @Column(name = "postedAt")
    private LocalDate postedAt;

    public Post(Long authorId, String text) {
        this.authorId = authorId;
        this.text = text;
    }
}
