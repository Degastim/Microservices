package com.epam.post.validator;

public interface DTOValidator<T> {
    boolean validate(T t);
}
