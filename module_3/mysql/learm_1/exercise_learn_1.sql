DROP DATABASE IF EXISTS student_manager;

DROP TABLE IF EXISTS CLASS;
CREATE TABLE CLASS (
id int,
name varchar(50));

DROP TABLE IF EXISTS TEACHER;
CREATE TABLE TEACHER (
id int,
name varchar(50),
age int,
country varchar(50) )
 