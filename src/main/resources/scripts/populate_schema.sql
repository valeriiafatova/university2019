use university;

INSERT INTO `user` (login, password, role, first_name, last_name) VALUES 
('admin','nimda','ADMIN', 'First', 'Last'),
('student','password','STUDENT', 'First', 'Last'),
('lecturer','password','LECTURER', 'First', 'Last'),
('lecturer2','password','LECTURER', 'First', 'Last'),
('lecturer3','password','LECTURER', 'First', 'Last');


insert into course (title, description) values 
('math', 'When television was young, there was a huge popular show based on the still popular fictional character of Superman.'), 
('language', 'When television was young, there was a huge popular show based on the still popular fictional character of Superman.'), 
('science', 'When television was young, there was a huge popular show based on the still popular fictional character of Superman.'), 
('creative', 'When television was young, there was a huge popular show based on the still popular fictional character of Superman.'), 
('social', 'When television was young, there was a huge popular show based on the still popular fictional character of Superman.');

insert into outline (title, course_id) values 
('Intro 1', 1), 
('Intro 2', 1), 
('Intro 3', 1),
('Intro 1', 2), 
('Intro 2', 2), 
('Intro 3', 2),
('Intro 1', 3), 
('Intro 2', 3), 
('Intro 3', 3),
('Intro 1', 4), 
('Intro 2', 4), 
('Intro 3', 4),
('Intro 1', 5), 
('Intro 2', 5), 
('Intro 3', 5);

insert into course_lecturer (lecturer_id, course_id) values 
(4, 1), 
(4, 2), 
(5, 3), 
(5, 4);
