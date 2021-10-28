-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

COMMENT ON SCHEMA public IS 'standard public schema';

-- Drop table

-- DROP TABLE public.cart_item;

CREATE TABLE public.cart_item (
	id int8 NOT NULL,
	price int8 NULL,
	quantity int4 NULL,
	order_id int8 NOT NULL,
	product_details_id int8 NOT NULL,
	CONSTRAINT cart_item_pkey PRIMARY KEY (id),
	CONSTRAINT fk3mu9lcrqocn2rdcm6xhbqrg3b FOREIGN KEY (order_id) REFERENCES public.orders(id),
	CONSTRAINT fkh7cv9fl479clyhnafburt8yls FOREIGN KEY (product_details_id) REFERENCES public.product_details(id)
);

-- Drop table

-- DROP TABLE public.categories;

CREATE TABLE public.categories (
	id int8 NOT NULL,
	category_title varchar(255) NULL,
	description varchar(255) NULL,
	CONSTRAINT categories_on_index UNIQUE (category_title),
	CONSTRAINT categories_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE public.orders (
	id int8 NOT NULL,
	amount int8 NULL,
	order_date timestamp NULL,
	order_status varchar(50) NULL,
	CONSTRAINT orders_pkey PRIMARY KEY (id),
	CONSTRAINT uk_2kasit4kby7sl36gesrfo3ofy UNIQUE (order_status)
);

-- Drop table

-- DROP TABLE public.product_details;

CREATE TABLE public.product_details (
	id int8 NOT NULL,
	color varchar(255) NULL,
	price int8 NULL,
	quantity int4 NULL,
	product_id int8 NOT NULL,
	CONSTRAINT product_details_pkey PRIMARY KEY (id),
	CONSTRAINT fknfvvq3meg4ha3u1bju9k4is3r FOREIGN KEY (product_id) REFERENCES public.products(id)
);

-- Drop table

-- DROP TABLE public.products;

CREATE TABLE public.products (
	id int8 NOT NULL,
	create_date timestamp NULL,
	image_url varchar(255) NULL,
	product_name varchar(255) NULL,
	status bool NULL,
	weight float8 NULL,
	category_id int8 NOT NULL,
	CONSTRAINT product_on_index UNIQUE (product_name),
	CONSTRAINT products_pkey PRIMARY KEY (id),
	CONSTRAINT fkog2rp4qthbtt2lfyhfo32lsw9 FOREIGN KEY (category_id) REFERENCES public.categories(id)
);

-- Drop table

-- DROP TABLE public.reviews;

CREATE TABLE public.reviews (
	id int8 NOT NULL,
	create_date timestamp NULL,
	img int2 NOT NULL,
	num_of_star int2 NULL,
	status int2 NULL,
	update_date timestamp NULL,
	order_id int8 NOT NULL,
	product_detail_id int8 NOT NULL,
	user_id int8 NOT NULL,
	CONSTRAINT reviews_pkey PRIMARY KEY (id),
	CONSTRAINT fkcgy7qjc1r99dp117y9en6lxye FOREIGN KEY (user_id) REFERENCES public.users(id),
	CONSTRAINT fkdii2jr3liylnwp5l6xowl2qyk FOREIGN KEY (product_detail_id) REFERENCES public.product_details(id),
	CONSTRAINT fkqwgq1lxgahsxdspnwqfac6sv6 FOREIGN KEY (order_id) REFERENCES public.orders(id)
);

-- Drop table

-- DROP TABLE public.roles;

CREATE TABLE public.roles (
	id int8 NOT NULL,
	role_name varchar(50) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id),
	CONSTRAINT uk_nb4h0p6txrmfc0xbrd1kglp9t UNIQUE (role_name)
);

-- Drop table

-- DROP TABLE public.sub_category;

CREATE TABLE public.sub_category (
	sub_category_id int8 NOT NULL,
	description varchar(255) NULL,
	sub_category_title varchar(255) NULL,
	category_id int8 NOT NULL,
	CONSTRAINT scate_index UNIQUE (sub_category_title),
	CONSTRAINT sub_category_pkey PRIMARY KEY (sub_category_id),
	CONSTRAINT fk76nk9rvg73ac82lf80hcy17r8 FOREIGN KEY (category_id) REFERENCES public.categories(id)
);

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id int8 NOT NULL,
	email varchar(255) NULL,
	full_name varchar(255) NULL,
	gender bool NULL,
	"password" varchar(20) NULL,
	phone varchar(255) NULL,
	username varchar(50) NULL,
	role_id int8 NULL,
	CONSTRAINT us_un_index UNIQUE (username),
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT fkp56c1712k691lhsyewcssf40f FOREIGN KEY (role_id) REFERENCES public.roles(id)
);
