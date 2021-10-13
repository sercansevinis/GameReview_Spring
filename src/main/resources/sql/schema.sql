create table genre(
    id identity PRIMARY key,
    gname varchar(255) NOT NULL
);

create table publisher(
    id identity PRIMARY key,
    pname varchar(255) NOT NULL,
    loc varchar(20),
    avgrate float,
    url varchar(50)
);

create table game(
    id IDENTITY PRIMARY KEY,
    pid int,
    gname varchar(255),
    Developers varchar(255),
    Platforms varchar(255),
    rrate int,
    rdate date,
    FOREIGN key(pid) REFERENCES publisher(id)
);

CREATE TABLE game_genre(
gaid bigint,
geid bigint,
FOREIGN KEY(gaid) REFERENCES game(id),
FOREIGN KEY(geid) REFERENCES genre(id)
);

create table user_(id identity primary key, usrname varchar(50), email varchar(50), pass varchar(15));
create table admin(id identity primary key, usrname varchar(50), email varchar(50), pass varchar(50));
