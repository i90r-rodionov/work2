drop table if exists t_user;

create table t_user
(
    c_id             bigint not null,
    c_username       varchar(256),
    c_firstname      varchar(128),
    c_lastname       varchar(128),
    c_email          varchar(256),
    c_phone          varchar(30),
    c_createdate     timestamp,
    c_lastchangedate timestamp,
    c_version        bigint,
    constraint pk_t_user primary key (c_id)
);

insert into T_USER
values (1, --c_id             bigint not null,
        'Username', -- c_username       varchar(256),
        'Firstname', -- c_firstname      varchar(128),
        'Lastname', -- c_lastname varchar(128),
        'user@domain.root', -- c_email varchar(256),
        '71231231212', --c_phone varchar(30),
        current_timestamp, -- c_createdate timestamp,
        current_timestamp, -- c_lastchangedate timestamp,
        0 --c_version bigint
       );

insert into T_USER
values (2, --c_id             bigint not null,
        'Username2', -- c_username       varchar(256),
        'Firstname2', -- c_firstname      varchar(128),
        'Lastname2', -- c_lastname varchar(128),
        'user2@domain.root', -- c_email varchar(256),
        '79876543210', --c_phone varchar(30),
        current_timestamp, -- c_createdate timestamp,
        current_timestamp, -- c_lastchangedate timestamp,
        0 --c_version bigint
       );