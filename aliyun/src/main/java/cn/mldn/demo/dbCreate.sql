DROP TABLE news PURGE;
DROP SEQUENCE news_seq;
CREATE SEQUENCE news_seq;
CREATE TABLE news
(
	nid 	NUMBER,
	title 	VARCHAR2(30),
	read 	NUMBER,
	price 	NUMBER,
	content CLOB,
	pubdate DATE,
	CONSTRAINT pk_id PRIMARY KEY(nid)
);
