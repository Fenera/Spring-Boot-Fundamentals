CREATE TABLE tags
(
    id      INT     PRIMARY KEY,
    name    VARCHAR(255) NOT NULL
);

CREATE TABLE user_tags
(
    user_id     BIGINT     NOT NULL,
    tag_id  BIGINT  NOT NULL,
    PRIMARY KEY (user_id, tag_id),
    /*if user row deleted in users table, deleted in user_tags also */
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    /* same for tags & user_tags */
    FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE
);