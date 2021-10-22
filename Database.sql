-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

COMMENT ON SCHEMA public IS 'standard public schema';

-- DROP SEQUENCE public.products_product_id_seq;

CREATE SEQUENCE public.products_product_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;
-- DROP SEQUENCE public.rating_rating_id_seq;

CREATE SEQUENCE public.rating_rating_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 2147483647
	START 1
	CACHE 1
	NO CYCLE;-- public.categories definition

-- Drop table

-- DROP TABLE public.categories;

CREATE TABLE public.categories (
	category_id int4 NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT categories_pkey PRIMARY KEY (category_id)
);


-- public.roles definition

-- Drop table

-- DROP TABLE public.roles;

CREATE TABLE public.roles (
	role_id varchar(255) NOT NULL,
	"name" varchar(255) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (role_id)
);


-- public.accounts definition

-- Drop table

-- DROP TABLE public.accounts;

CREATE TABLE public.accounts (
	username varchar(255) NOT NULL,
	address varchar(255) NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	"password" varchar(255) NULL,
	phone varchar(255) NULL,
	role_id varchar(255) NULL,
	CONSTRAINT accounts_pkey PRIMARY KEY (username),
	CONSTRAINT fkt3wava8ssfdspnh3hg4col3m1 FOREIGN KEY (role_id) REFERENCES public.roles(role_id)
);


-- public.products definition

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	product_id serial4 NOT NULL,
	create_date date NULL,
	images varchar(255) NULL,
	"name" varchar(255) NULL,
	price float8 NULL,
	update_date date NULL,
	category_id int4 NULL,
	CONSTRAINT products_pkey PRIMARY KEY (product_id),
	CONSTRAINT fkog2rp4qthbtt2lfyhfo32lsw9 FOREIGN KEY (category_id) REFERENCES public.categories(category_id)
);


-- public.rating definition

-- Drop table

-- DROP TABLE public.rating;

CREATE TABLE public.rating (
	rating_id serial4 NOT NULL,
	"comment" varchar(255) NULL,
	rating_dislike int4 NULL,
	rating_like int4 NULL,
	product_id int4 NULL,
	CONSTRAINT rating_pkey PRIMARY KEY (rating_id),
	CONSTRAINT fk4odf7rh1jmwmew4dnowoc73cf FOREIGN KEY (product_id) REFERENCES public.products(product_id)
);
