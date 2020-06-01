--schema.sql
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

drop table test if exists;
create table test(
    id bigint primary key auto_increment,
    name varchar(20) not null
);