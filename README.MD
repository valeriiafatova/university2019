Course system.
///////Задача 
Requirements:
1. DB - MySql/PostgreSql
2. Java version up 8.
3. Maven


How to install:
1. Clone project
2. Run schema.sql from resources/ folder
3. Run populate.sql from resources/data/ folder
4. (Add TOMCAT_FOLDER/conf/server.xml ->  resources/context/context.xml) -> 
UPDATE DB LOGIN PASSWORD 
5. Run in terminal command 
a. mvn clean tomcat7:run
b. ? Add configuration / command 
6. Go to link XXXX

Business logic: 
1. User could login as lecturer or student. - LoginCommand
2. Student could register on site. - RegisterCommand
3. All could see courses page. - CoursesCommand (GET)
4. All could see specific course page. - CoursesCommand (GET)
5. Student could apply to course.  - CoursesCommand (POST)
6. Lecturer could add ratings - LecturerRatingCommand (POST)
7. Lecturer could see all ratings for his courses - LecturerRatingCommand (GET)
8. Admin could add Lecturer user - AdminCommand
9. Admin could add Course - AdminCommand
10. Admin could see Ratings - AdminRatingCommand
11. Admin could change Ratings - AdminRatingCommand
12. Student could see Ratings - StudentRatingCommand
13. User on site could change language - LanguageCommand
14. Admin could send notifications - NotificationCommand
15. User could logout 
