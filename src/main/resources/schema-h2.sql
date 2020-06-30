--schema.sql
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

drop table test if exists;
drop table user_tbl if exists;
drop table board_tbl if exists;
drop table comment_tbl if exists;
drop table pin_tbl if exists;

create table test(
    id bigint primary key auto_increment,
    name varchar(20) not null
);

create table user_tbl(
    idx INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    auth VARCHAR(255),
    regist_date DATETIME DEFAULT NOW(),
    update_date DATETIME DEFAULT NOW(),
    last_login_date DATETIME DEFAULT NOW()
);
CREATE INDEX ON user_tbl(id);

create table board_tbl(
    idx INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100),
    content TEXT ,
    views INT DEFAULT 0,
    pin boolean DEFAULT false,
    regist_idx INT,
    regist_date DATETIME DEFAULT NOW(),
    update_date DATETIME DEFAULT NOW()
);
CREATE INDEX ON board_tbl(regist_idx);

create table comment_tbl(
    idx INT PRIMARY KEY AUTO_INCREMENT,
    board_idx INT,
    parent_idx INT NULL,
    content VARCHAR(255),
    order_no SMALLINT,
    regist_idx INT,
    regist_date DATETIME DEFAULT NOW(),
    update_date DATETIME DEFAULT NOW()
);
CREATE INDEX ON comment_tbl(parent_idx);