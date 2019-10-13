drop schema if exists university;
create schema university character set utf8 collate utf8_general_ci;
use university;
create table role (
id int auto_increment,
role varchar(255),
primary key (id));

create table user (
id Int auto_increment,
login varchar(255) unique,
password varchar(255) not null,
roleId int,
primary key (id), 
constraint c_role 
foreign key (roleId) references role(id));

create table specialty (
id int auto_increment,
title varchar(255) not null,
primary key (id));

create table `subject` (
id int auto_increment,
title varchar(255) not null,
primary key (id));

create table subject_lecture(
id int auto_increment,
lectureId int,
subjectId int,
primary key(id), 
foreign key (lectureId) references user(id),
foreign key (subjectId) references subject(id),
unique key `subjectLecturex` (lectureId, subjectId));

create table subject_specialty(
id int auto_increment,
specialtyId int,
subjectId int,
primary key(id), 
foreign key (specialtyId) references specialty(id),
foreign key (subjectId) references subject(id),
unique key `subjectSpecialtyx` (specialtyId, subjectId));

create table rating(
id int auto_increment,
studentId int,
subjectId int,
`date` date, 
rating enum("A", "B", "C", "D", "E"),
primary key(id),
foreign key (studentId) references user(id),
foreign key (subjectId) references subject(id));

create table notification(
id int auto_increment,
studentId int, 
`date` date,
primary key (id),
foreign key (studentId) references user(id));