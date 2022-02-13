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