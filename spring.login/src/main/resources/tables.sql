-- Drop table

-- DROP TABLE public.tb_user;

CREATE TABLE public.tb_user (
	id numeric NOT NULL,
	username text NULL,
	"password" text NULL
);

-- Drop table

-- DROP TABLE public.book;

CREATE TABLE public.book (
	id serial NOT NULL,
	cover varchar(255) NULL DEFAULT ''::character varying,
	title varchar(255) NOT NULL DEFAULT ''::character varying,
	author varchar(255) NULL DEFAULT ''::character varying,
	"date" varchar(20) NULL DEFAULT ''::character varying,
	press varchar(255) NULL DEFAULT ''::character varying,
	abs varchar(255) NULL DEFAULT NULL::character varying,
	cid int4 NULL,
	CONSTRAINT book_pk PRIMARY KEY (id),
	CONSTRAINT book_fk FOREIGN KEY (cid) REFERENCES category(id) ON UPDATE CASCADE ON DELETE SET NULL
);


-- Drop table

-- DROP TABLE public.category;

CREATE TABLE public.category (
	id int4 NOT NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT category_pk PRIMARY KEY (id)
);
