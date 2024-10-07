CREATE TABLE IF NOT EXISTS messages (
    id       VARCHAR(60)  default RANDOM_UUID() primary key,
    text     VARCHAR      NOT NULL
);