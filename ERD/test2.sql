SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS rep;
DROP TABLE IF EXISTS review_brd;
DROP TABLE IF EXISTS zzim;
DROP TABLE IF EXISTS class;
DROP TABLE IF EXISTS cur;
DROP TABLE IF EXISTS ins;
DROP TABLE IF EXISTS mb;
DROP TABLE IF EXISTS news_brd;




/* Create Tables */

CREATE TABLE class
(
	class_uid int NOT NULL AUTO_INCREMENT,
	cur_uid int NOT NULL,
	ins_uid int NOT NULL,
	class_zzimcnt int default 0,
	PRIMARY KEY (class_uid)
);


CREATE TABLE cur
(
	cur_uid int NOT NULL AUTO_INCREMENT,
	cur_name varchar(50) NOT NULL,
	cur_hours int NOT NULL,
	cur_months int NOT NULL,
	cur_month1 text,
	cur_month2 text,
	cur_month3 text,
	cur_month4 text,
	cur_month5 text,
	cur_month6 text,
	PRIMARY KEY (cur_uid)
);


CREATE TABLE ins
(
	ins_uid int NOT NULL AUTO_INCREMENT,
	ins_name varchar(50) NOT NULL,
	ins_tel varchar(20) NOT NULL,
	ins_zip int,
	ins_add1 text NOT NULL,
	ins_add2 text NOT NULL,
	ins_location varchar(20) NOT NULL,
	ins_branch varchar(20) NOT NULL,
	ins_img text default 0,
	ins_x double DEFAULT 37.5582373,
	ins_y double DEFAULT 126.8164805,
	PRIMARY KEY (ins_uid)    
);


CREATE TABLE mb
(
	mb_uid int NOT NULL AUTO_INCREMENT,
	mb_id varchar(20) NOT NULL,
	mb_pw varchar(20) NOT NULL,
	mb_name varchar(20) NOT NULL,
	mb_email varchar(60) NOT NULL,
	mb_zip int NOT NULL,
	mb_add1 text NOT NULL,
	mb_add2 text NOT NULL,
	mb_level int default 1,
	mb_regdate datetime default now(),
	mb_img text default 0,
	PRIMARY KEY (mb_uid),
	UNIQUE (mb_id),
	UNIQUE (mb_email)
);


CREATE TABLE news_brd
(
	news_brd_uid int NOT NULL AUTO_INCREMENT,
	news_brd_title varchar(50) NOT NULL,
	news_brd_img text,
	news_brd_content text,
	news_brd_viewcnt int DEFAULT 0,
	PRIMARY KEY (news_brd_uid)
);


CREATE TABLE rep
(
	rep_uid int NOT NULL AUTO_INCREMENT,
	rep_content text NOT NULL,
	rep_regdate datetime default now(),
	mb_uid int NOT NULL,
	review_brd_uid int NOT NULL,
	PRIMARY KEY (rep_uid)
);


CREATE TABLE review_brd
(
	review_brd_uid int NOT NULL AUTO_INCREMENT,
	review_brd_title varchar(50) NOT NULL,
	review_brd_content text NOT NULL,
	review_brd_regdate datetime default now(),
	review_brd_viewcnt int default 0,
	mb_uid int NOT NULL,
	class_uid int NOT NULL,
	PRIMARY KEY (review_brd_uid)
);


CREATE TABLE zzim
(
	mb_uid int NOT NULL,
	zzim_uid int NOT NULL AUTO_INCREMENT,
	class_uid int NOT NULL,
	PRIMARY KEY (zzim_uid)
);



/* Create Foreign Keys */

ALTER TABLE review_brd
	ADD FOREIGN KEY (class_uid)
	REFERENCES class (class_uid)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE zzim
	ADD FOREIGN KEY (class_uid)
	REFERENCES class (class_uid)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE class
	ADD FOREIGN KEY (cur_uid)
	REFERENCES cur (cur_uid)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE class
	ADD FOREIGN KEY (ins_uid)
	REFERENCES ins (ins_uid)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE rep
	ADD FOREIGN KEY (mb_uid)
	REFERENCES mb (mb_uid)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE review_brd
	ADD FOREIGN KEY (mb_uid)
	REFERENCES mb (mb_uid)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE zzim
	ADD FOREIGN KEY (mb_uid)
	REFERENCES mb (mb_uid)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;
 
 
ALTER TABLE rep
	ADD FOREIGN KEY (review_brd_uid)
	REFERENCES review_brd (review_brd_uid)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;




SELECT * FROM mb;
SELECT * FROM class;
SELECT * FROM cur;
select * from ins;
select * from zzim;

SELECT z.*, ins_name, cur_name FROM zzim z, ins i, cur WHERE z.mb_uid = 2;

insert into mb (mb_id, mb_pw, mb_name, mb_email, mb_zip, mb_add1, mb_add2) 
values ('user1', 'abc123', '이미지', 'wkrud94@hanmail.net', 07030, '서울시', '동작구');
insert into mb (mb_id, mb_pw, mb_name, mb_email, mb_zip, mb_add1, mb_add2) 
values ('user2', 'bsd912', '이새힘', 'teste@yahoo.com', 03210, '서울시', '관악구');
insert into mb (mb_id, mb_pw, mb_name, mb_email, mb_zip, mb_add1, mb_add2) 
values ('user3', 'dsrrws1', '박지민', 'emmail@gmail.com', 14410, '인천광역시', '팔달구');
insert into mb (mb_id, mb_pw, mb_name, mb_email, mb_zip, mb_add1, mb_add2) 
values ('user4', 'retw_12', '박우람', 'abced@hanmail.net', 01035, '경기도', '평택');
insert into mb (mb_id, mb_pw, mb_name, mb_email, mb_zip, mb_add1, mb_add2) 
values ('user5', '12_dsf', '김민하', 'ddsf133@hanmail.net', 91105, '부천시', '원미구');

update ins set ins_zip = 11111 where ins_name = '비트캠프';
insert into ins (ins_name, ins_tel, ins_add1, ins_add2, ins_location, ins_branch) 
values ('코리아IT', '02-991-2321', '서울시 관악구', '행복동', '서울', '관악');
insert into ins (ins_name, ins_tel, ins_add1, ins_add2, ins_location, ins_branch) 
values ('그린IT', '031-323-3242', '경기도', '부천시', '경기', '부천');
insert into ins (ins_name, ins_tel, ins_add1, ins_add2, ins_location, ins_branch) 
values ('비트캠프', '02-542-9422', '서울시 강남구', '서초동', '서울', '강남');
insert into ins (ins_name, ins_tel, ins_add1, ins_add2, ins_location, ins_branch) 
values ('KG&G', '02-3238-1299', '서울시 동작구', '노량진동', '서울', '노량진');
insert into ins (ins_name, ins_tel, ins_add1, ins_add2, ins_location, ins_branch) 
values ('SBS아카데미', '064-548-4639', '광주광역시 서구', '떙땡', '광주', '서구');


insert into cur (cur_name, cur_months, cur_hours) 
values ('웹앱', 3, 50);
insert into cur (cur_name, cur_months, cur_hours)
values ('보안', 8, 390);
insert into cur (cur_name, cur_months, cur_hours) 
values ('네트워크', 2, 90);
insert into cur (cur_name, cur_months, cur_hours)
values ('안드로이드', 1, 40);
insert into cur (cur_name, cur_months, cur_hours) 
values ('자바', 6, 400);


insert into class(ins_uid, cur_uid, class_zzimcnt)
values(1, 1, 10);
insert into class(ins_uid, cur_uid, class_zzimcnt)
values(1, 3, 121);
insert into class(ins_uid, cur_uid, class_zzimcnt)
values(2, 5, 90);
insert into class(ins_uid, cur_uid, class_zzimcnt)
values(2, 3, 430);
insert into class(ins_uid, cur_uid, class_zzimcnt)
values(3, 3, 44);
insert into class(ins_uid, cur_uid, class_zzimcnt)
values(3, 1, 64);
insert into class(ins_uid, cur_uid, class_zzimcnt)
values(4, 5, 4334);
insert into class(ins_uid, cur_uid, class_zzimcnt)
values(4, 2, 144);
