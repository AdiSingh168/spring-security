CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled  BOOLEAN      NOT NULL
);
CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

INSERT INTO users
VALUES ('user', '{noop}EazyBytes@12345', '1');
INSERT INTO authorities
VALUES ('user', 'read');

INSERT INTO users
VALUES ('admin', '{bcrypt}$2a$12$88.f6upbBvy0okEa7OfHFuorV29qeK.sVbB9VQ6J6dWM1bW6Qef8m', '1');
INSERT INTO authorities
VALUES ('admin', 'admin');

CREATE TABLE customer
(
    id    SERIAL       NOT NULL PRIMARY KEY,
    email varchar(50)  NOT NULL,
    pwd   varchar(200) NOT NULL,
    role  varchar(50)  NOT NULL
);

INSERT INTO customer(email, pwd, role)
VALUES ('happy@example.com', '{noop}', 'read');
INSERT INTO customer(email, pwd, role)
VALUES ('admin@example.com', '{bcrypt}$2a$12$88.f6upbBvy0okEa7OfHFuorV29qeK.sVbB9VQ6J6dWM1bW6Qef8m', 'admin');