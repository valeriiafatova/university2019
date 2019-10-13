use university;
insert into role (role) values ('admin'), ('user'), ('student'), ('lecturer');

insert into user (login, password, roleId) values 
('admin', 'nimda', 1),
('anonymous', 'password', 2),
('student', 'password', 3),
('lecturer', 'password', 4),
('lecturer2', 'password', 4),
('lecturer3', 'password', 4);

insert into major (title) values ('Psychology'), ('Engineering'), ('Business and Management');

insert into subject (title) values ('math'), ('language'), ('science'), ('creative'), ('social'), ('business analytics');

insert into subject_lecturer (lecturerId, subjectId) values (4, 1), (4, 2), (5, 3), (5,4), (6,2);

insert into subject_major (majorId, subjectId, required) values (1,1,1) , (1,2,1), (1,4,0), (1,5,0),
(2,1,1), (2,3,1), (2,4,0), (2,6,0),
(3,1,1), (3,2,1), (3,5,0), (3,6,0);