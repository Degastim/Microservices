package com.epam.user.service;

import com.epam.user.dto.UserAmountOfPost;
import com.epam.user.dto.UserDTO;
import com.epam.user.dto.UserNameDTO;
import com.epam.user.entity.User;

public interface UserService {
    UserDTO findById(long id);
    UserDTO create(UserNameDTO userNameDTO);

    void delete(long id);

    UserDTO update(long id, UserNameDTO userNameDTO);

    UserDTO updateAmountOfPost(long id, UserAmountOfPost userAmountOfPost);
}
