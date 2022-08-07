CREATE TABLE if not exists todo (
                        id VARCHAR(100) NOT NULL PRIMARY KEY,
                        text VARCHAR(100) NULL DEFAULT '',
                        done boolean
);



create table if not exists t_session(
    id              varchar(255) primary key,
    room_id         varchar(255) not null ,
    movie_id        varchar(255) not null,
    seats_info      varchar(1000) not null,
    start_time      timestamp not null ,
    end_time        timestamp not null ,
    screening_date  timestamp not null  ,
    price           DECIMAL(30,5) not null
);

create table if not exists t_room(
   id               varchar(255) primary key ,
   room_name        varchar(255) not null,
   seats_layout     varchar(255) not null ,
   cinema_id        varchar(255) not null
);

create table if not exists t_cinema(
    id              varchar(255) primary key,
    cinema_name     varchar(255) not null ,
    address         varchar(255) default ''
);

create table if not exists t_movie(
    id             varchar(255) primary key,
    movie_name     varchar(60) not null,
    actors         varchar(255) default '',
    movie_desc     varchar(500) default '',
    release_date   datetime null,
    score          float  default 0.0,
    cover          varchar(255) default '' ,
    video          varchar(255) default '',
    duration       int null ,
    duration_unit  varchar(255) null
);

CREATE TABLE IF not EXISTS t_user (
                      id varchar(30) NOT NULL,
                      username varchar(32) NOT NULL ,
                      nickname varchar(32) NOT NULL,
                      password varchar(60) NOT NULL ,
                      role_id varchar(100) DEFAULT ,
                      avatar varchar(255) NOT NULL,
                      phone varchar(100) DEFAULT '',
                      sign varchar(100) DEFAULT '' ,
                      status varchar(10) DEFAULT '1',
                      create_time timestamp NULL ,
                      update_time timestamp NULL ,
                      PRIMARY KEY (`id`)
);

CREATE TABLE IF not EXISTS t_role (
                      id varchar(30) NOT NULL,
                      role_name varchar(32) NOT NULL,
                      PRIMARY KEY (`id`)
);


CREATE TABLE IF not EXISTS t_order (
                         id varchar(30) NOT NULL,
                         price DECIMAL(30,5) NOT NULL,
                         status varchar(10) DEFAULT '0',
                         session_id varchar(100) DEFAULT '-1' ,
                         movie_id varchar(100) DEFAULT '-1',
                         cinema_id varchar(100) DEFAULT '-1',
                         room_id varchar(100) DEFAULT '-1',
                         user_id varchar(100) DEFAULT '-1',
                         seat_info varchar(100) DEFAULT '-1',
                         PRIMARY KEY (`id`)
);