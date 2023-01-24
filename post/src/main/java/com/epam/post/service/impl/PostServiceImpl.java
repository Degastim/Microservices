package com.epam.post.service.impl;

import com.epam.post.dao.PostDao;
import com.epam.post.dto.*;
import com.epam.post.entity.Post;
import com.epam.post.exception.InvalidFieldValueException;
import com.epam.post.exception.ResourceNotFoundException;
import com.epam.post.mapper.DTOMapper;
import com.epam.post.service.PostService;
import com.epam.post.validator.DTOValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDao postDao;
    private final DTOMapper<Post, PostDTO> postDTOMapper;
    private final DTOMapper<Post, PostDataDTO> postDataDTOMapper;
    private final DTOValidator<PostDataDTO> postDataDTOValidator;
    private final DTOValidator<PostTextDTO> postTextDTOValidator;
    private final RestTemplate restTemplate;
    private static final String USERS_URL="http://user-service:8081/users/";

    @Override
    public PostDTO findById(long id) {
        Post post = postDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post doesn’t exist with given id"));
        return postDTOMapper.toDTO(post);
    }

    @Override
    public PostDTO create(PostDataDTO postDataDTO) {
        if (!postDataDTOValidator.validate(postDataDTO)) {
            throw new InvalidFieldValueException("Validation error or request body is an invalid");
        }
        Post post = postDataDTOMapper.toEntity(postDataDTO);
        post.setPostedAt(LocalDate.now());
        post = postDao.save(post);
        String url = USERS_URL + post.getAuthorId();
        restTemplate.patchForObject(url, new UserAuthorIdDTO(1), UserDTO.class);
        return postDTOMapper.toDTO(post);
    }

    @Override
    public void delete(long id) {
        Post post = postDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        String url = USERS_URL + post.getAuthorId();
        restTemplate.patchForObject(url, new UserAuthorIdDTO(-1), UserDTO.class);
        postDao.deleteById(id);
    }

    @Override
    public PostDTO update(long id, PostTextDTO postTextDTO) {
        if (!postTextDTOValidator.validate(postTextDTO)) {
            throw new InvalidFieldValueException("Validation error or request body is an invalid");
        }
        Post post = postDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post doesn’t exist with given id"));
        String text = postTextDTO.getText();
        post.setText(text);
        post = postDao.save(post);
        return postDTOMapper.toDTO(post);
    }
}
