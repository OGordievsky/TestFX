DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
    id       INT8 PRIMARY KEY DEFAULT nextval('global_seq'),
    name     VARCHAR                       NOT NULL,
    title    VARCHAR                       NOT NULL,
    login    VARCHAR                       NOT NULL,
    password VARCHAR                       NOT NULL,
    location VARCHAR                       NOT NULL,
    gender   BOOL             DEFAULT TRUE NOT NULL
);
CREATE UNIQUE INDEX users_unique_idx ON users (id);