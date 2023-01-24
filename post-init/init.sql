CREATE TABLE posts
(
    post_id         BIGSERIAL    NOT NULL ,
    author_id       BIGINT       NOT NULL,
    text            VARCHAR(100)  NOT NULL,
    postedAt        timestamp    NOT NULL,
    PRIMARY KEY (post_id)
);
