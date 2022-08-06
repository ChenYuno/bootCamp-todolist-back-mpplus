CREATE TABLE if not exists todo (
                        id VARCHAR(100) NOT NULL PRIMARY KEY,
                        text VARCHAR(100) NULL DEFAULT '',
                        done boolean
);