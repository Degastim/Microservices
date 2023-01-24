package com.epam.user.service.impl;

import com.epam.user.dao.UserDao;
import com.epam.user.dto.UserAmountOfPost;
import com.epam.user.dto.UserDTO;
import com.epam.user.dto.UserNameDTO;
import com.epam.user.entity.User;
import com.epam.user.exception.InvalidFieldValueException;
import com.epam.user.exception.ResourceNotFoundException;
import com.epam.user.mapper.DTOMapper;
import com.epam.user.service.UserService;
import com.epam.user.validator.DTOValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    private final DTOMapper<User, UserNameDTO> userNameDTOMapper;
    private final DTOMapper<User, UserDTO> userDTOMapper;
    private final DTOValidator<UserNameDTO> userNameDTOValidator;

    public UserServiceImpl(UserDao userDao, DTOMapper<User, UserNameDTO> userNameDTOMapper, DTOMapper<User,
            UserDTO> userDTOMapper, DTOValidator<UserNameDTO> userNameDTOValidator) {
        this.userDao = userDao;
        this.userNameDTOMapper = userNameDTOMapper;
        this.userDTOMapper = userDTOMapper;
        this.userNameDTOValidator = userNameDTOValidator;
    }

    @Override
    public UserDTO findById(long id) {
        User user = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User doesn’t exist with given id"));
        return userDTOMapper.toDTO(user);
    }

    @Override
    public UserDTO create(UserNameDTO userDTO) {
        if (!userNameDTOValidator.validate(userDTO)) {
            throw new InvalidFieldValueException("Validation error or request body is an invalid");
        }
        User user = userNameDTOMapper.toEntity(userDTO);
        user.setAmountOfPost("0");
        user = userDao.save(user);
        return userDTOMapper.toDTO(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        userDao.deleteById(id);
    }

    @Override
    public UserDTO update(long id, UserNameDTO userNameDTO) {
        if (!userNameDTOValidator.validate(userNameDTO)) {
            throw new InvalidFieldValueException("Validation error or request body is an invalid");
        }
        User user = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User doesn’t exist with given id"));
        String userName = userNameDTO.getUsername();
        user.setUsername(userName);
        userDao.save(user);
        return userDTOMapper.toDTO(user);
    }

    @Override
    public UserDTO updateAmountOfPost(long id, UserAmountOfPost userAmountOfPost) {
        User user = userDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User doesn’t exist with given id"));
        String stringAmountOfPost = user.getAmountOfPost();
        int amountOfPost = Integer.parseInt(stringAmountOfPost);
        amountOfPost = amountOfPost + userAmountOfPost.getAmountOfPostChanged();
        user.setAmountOfPost(Integer.toString(amountOfPost));
        userDao.save(user);
        return userDTOMapper.toDTO(user);
    }
}
