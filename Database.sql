create table category (
	category_id integer constraint category_id_nn not null, 
	name varchar(50)
);

alter table category 
add constraint cate_id_pk primary key(category_id);

create table rating (
	rating_id integer constraint rating_id not null, 
	product_id integer not null, 
	rating_like int not null,
	rating_dislike int not null
);

alter table rating 
add constraint rating_id_pk primary key(rating_id); 

create table product(
	product_id integer constraint product_id_nn not null,
	name varchar(50) not null, 
	price float not null,
	images varchar(50) not null, 
	create_date date not null, 
	update_date date not null, 
	category_id integer not null
);

alter table product 
add constraint product_id_pk primary key(product_id);

alter table product 
add constraint product_cate_fk foreign key (category_id) references category(category_id);

alter table rating 
add constraint rating_product_fk foreign key (product_id) references product(product_id);


create table userRole(
	role_id varchar(10) constraint role_id_nn not null, 
	name    varchar(50) not null 
);

alter table userRole 
add constraint role_id_pk primary key (role_id);

create table account(
	username varchar(50) constraint account_username_nn not null, 
	password varchar(50) not null, 
	first_name varchar(50) not null, 
	last_name varchar(50) not null,
	phone varchar(10) not null,
	address varchar(10) not null
);

alter table account 
add constraint account_username_pk primary key (username);

create table authorize(
	id integer constraint authorize_id_nn not null, 
	username varchar(50) not null, 
	role_id varchar(10) not null 
);

alter table authorize 
add constraint authorize_id_pk primary key (id);

alter table authorize 
add constraint authozie_account_fk foreign key (username) references account(username);

alter table authorize 
add constraint authorize_role_fk foreign key (role_id) references userRole(role_id);