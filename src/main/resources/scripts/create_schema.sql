drop schema if exists university;
create schema university character set utf8 collate utf8_general_ci;
use university;

create table user
(
    id         Int auto_increment,
    login      varchar(255) unique,
    password   varchar(255) not null,
    `role`     enum ('ADMIN','STUDENT','LECTURER'),
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    primary key (id)
);

create table course
(
    id          int auto_increment,
    title       varchar(255) not null,
    description varchar(255) not null,
    primary key (id)
);

create table outline
(
    id        int auto_increment,
    title     varchar(255) not null,
    course_id int,
    primary key (id),
    foreign key (course_id) references course (id)
);

create table course_lecturer
(
    id          int auto_increment,
    lecturer_id int,
    course_id   int,
    primary key (id),
    foreign key (lecturer_id) references user (id),
    foreign key (course_id) references course (id),
    unique key `courseLecturerx` (lecturer_id, course_id)
);

create table rating
(
    id         int auto_increment,
    student_id int,
    course_id  int,
    `date`     date,
    rating     enum ('A', 'B', 'C', 'D', 'E'),
    primary key (id),
    foreign key (student_id) references user (id),
    foreign key (course_id) references course (id)
);

create table notification
(
    id         int auto_increment,
    student_id int,
    `date`     date,
    primary key (id),
    foreign key (student_id) references user (id)
);