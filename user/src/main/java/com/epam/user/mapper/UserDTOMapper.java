package com.epam.user.mapper;

import com.epam.user.dto.UserDTO;
import com.epam.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper implements DTOMapper<User, UserDTO>{
    @Override
    public User toEntity(UserDTO dto) {
        return new User(dto.getId(),dto.getUsername(),dto.getAmountOfPosts());
    }

    @Override
    public UserDTO toDTO(User entity) {
        return new UserDTO(entity.getId(),entity.getUsername(),entity.getAmountOfPost());
    }
}
