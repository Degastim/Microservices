package com.epam.user.validator;

public interface DTOValidator<T> {
    boolean validate(T t);
}
