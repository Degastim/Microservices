package com.epam.user.mapper;


public interface DTOMapper<T, R> {
    T toEntity(R dto);

    R toDTO(T entity);
}
