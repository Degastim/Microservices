package com.epam.user.mapper;

import com.epam.user.dto.UserNameDTO;
import com.epam.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserNameDTOMapper implements DTOMapper<User, UserNameDTO> {
    @Override
    public User toEntity(UserNameDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        return user;

    }

    @Override
    public UserNameDTO toDTO(User entity) {
        return new UserNameDTO(entity.getUsername());
    }
}
