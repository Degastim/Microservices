package com.epam.post.controller;

import com.epam.post.dto.PostDTO;
import com.epam.post.dto.PostDataDTO;
import com.epam.post.dto.PostTextDTO;
import com.epam.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("/{id}")
    public PostDTO find(@PathVariable long id) {
        return postService.findById(id);
    }

    @PostMapping
    public PostDTO create(@RequestBody(required = false) PostDataDTO postDataDTO) {
        return postService.create(postDataDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable long id) {
        postService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("OK"));
    }

    @PutMapping("/{id}")
    public PostDTO update(@PathVariable long id, @RequestBody(required = false) PostTextDTO postTextDTO) {
        return postService.update(id, postTextDTO);
    }
}
