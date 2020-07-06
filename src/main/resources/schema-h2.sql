--schema.sql
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

drop table test if exists;
create table test(
    id bigint primary key auto_increment,
    name varchar(20) not null
);

drop table user_tbl if exists;
create table user_tbl(
    idx INT PRIMARY KEY AUTO_INCREMENT,
    id VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    profile_image VARCHAR(255),
    third_party_type ENUM('kakao'),
    third_party_id VARCHAR(255),
    regist_date DATETIME DEFAULT NOW(),
    update_date DATETIME DEFAULT NOW(),
    last_login_date DATETIME DEFAULT NOW()
);

drop table board_tbl if exists;
create table board_tbl(
    idx INT PRIMARY KEY AUTO_INCREMENT,
    user_idx INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    tag VARCHAR(255),
    views INT DEFAULT 0,
    pin boolean DEFAULT false,
    regist_date DATETIME DEFAULT NOW(),
    update_date DATETIME DEFAULT NOW()
);

drop table comment_tbl if exists;
create table comment_tbl(
    idx INT PRIMARY KEY AUTO_INCREMENT,
    board_idx INT NOT NULL,
    parent_idx INT,
    user_idx INT NOT NULL,
    order_no SMALLINT,
    content VARCHAR(255) NOT NULL,
    regist_date DATETIME DEFAULT NOW(),
    update_date DATETIME DEFAULT NOW()
);
