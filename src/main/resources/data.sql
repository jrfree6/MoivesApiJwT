drop table if exists movies;

create table movies (
	id int auto_increment primary key,
	title varchar(250), 
	releasedate date,
	genre varchar(120), 
	overview text,
	rating varchar(20)
);

insert into movies (title, releasedate, genre, overview, rating ) 
values( 'Raya and the Last Dragon','2021-01-01','Animation', 'no-text','7' );

drop table if exists user;

create table user (
	id int auto_increment primary key,
	email varchar(120),
	name varchar(120),
	password varchar(80),
	created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

insert  into user ( email, name, password)
values ( 'teste@teste.com', 'userteste','@teste123');