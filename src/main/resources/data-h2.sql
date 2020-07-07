--data.sql
insert into test values(1, 'hong');
insert into test values(2, 'kim');
insert into test values(3, 'james');
insert into test values(4, 'kim');
insert into test values(5, 'jane');
insert into test values(6, 'lim');
insert into test values(7, 'jack');

--user_tbl
insert into user_tbl(idx, id, password, regist_date, update_date) values(1, 'testid', 'testpass', '2020-06-09 13:27:05', '2020-06-09 13:27:05');
insert into user_tbl(idx, id, password, profile_image, regist_date, update_date, last_login_date) values(2, 'testid2', 'testpass', 'https://img-s-msn-com.akamaized.net/tenant/amp/entityid/BB11wjv9.img?h=378&w=378&m=6&q=60&o=f&l=f&x=329&y=160', '2020-06-09 13:27:05', '2020-06-09 13:27:05', '2020-07-08 03:44:16');