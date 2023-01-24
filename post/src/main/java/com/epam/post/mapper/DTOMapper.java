package com.epam.post.mapper;


public interface DTOMapper<T, R> {
    T toEntity(R dto);

    R toDTO(T entity);
}
