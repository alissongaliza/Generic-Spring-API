    create table "user" (
        id uuid PRIMARY KEY,
        email varchar(30) NOT NULL,
        password varchar(64) NOT NULL,
        lastName varchar(30) NOT NULL,
        firstName varchar(30) NOT NULL
    );