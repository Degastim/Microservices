CREATE TABLE users
(
    user_id         BIGSERIAL      NOT NULL ,
    user_name      VARCHAR(40) NOT NULL,
    amountOfPost         VARCHAR(10) NOT NULL,
    PRIMARY KEY (user_id)
);