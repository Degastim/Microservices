package com.epam.user.validator;

import com.epam.user.dto.UserNameDTO;
import org.springframework.stereotype.Component;

@Component
public class UserNameDTOValidator implements DTOValidator<UserNameDTO> {
    public boolean validate(UserNameDTO userNameDTO) {
        return userNameDTO.getUsername() != null;
    }
}
