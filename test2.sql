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
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE zzim
	ADD FOREIGN KEY (class_uid)
	REFERENCES class (class_uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE class
	ADD FOREIGN KEY (cur_uid)
	REFERENCES cur (cur_uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE class
	ADD FOREIGN KEY (ins_uid)
	REFERENCES ins (ins_uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rep
	ADD FOREIGN KEY (mb_uid)
	REFERENCES mb (mb_uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE review_brd
	ADD FOREIGN KEY (mb_uid)
	REFERENCES mb (mb_uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE zzim
	ADD FOREIGN KEY (mb_uid)
	REFERENCES mb (mb_uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE rep
	ADD FOREIGN KEY (review_brd_uid)
	REFERENCES review_brd (review_brd_uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



