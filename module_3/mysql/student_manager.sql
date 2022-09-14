CREATE database quanLySinhVien;
USE quanLySinhVien;

CREATE TABLE class(
class_id int auto_increment primary key not null,
class_name varchar(60),
start_date date,
`status` bit);

CREATE TABLE student(
student_id int auto_increment primary key not null,
student_name varchar(50) not null,
address varchar(50),
phone varchar(50),
`status` bit,
class_id int NOT NULL,
foreign key(class_id) references class(class_id));

CREATE TABLE subject(
sub_id int auto_increment primary key not null,
sub_name varchar(30) not null,
creadit int not null default 1 check (creadit >= 1),
status bit default 1);

CREATE TABLE mark(
mark_id int auto_increment primary key not null,
sub_id int not null ,
student_id int not null,
mark float default 0 check (mark between 0 and 100) ,
exam_times tinyint default 1,
unique (sub_id , student_id),
foreign key(sub_id) references subject(sub_id),
foreign key(student_id) references student(student_id));


INSERT INTO class
VALUES (1, 'A1', '2008-12-20', 1);
INSERT INTO Class
VALUES (2, 'A2', '2008-12-22', 1);
INSERT INTO Class
VALUES (3, 'B3', current_date, 0);

INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Hung', 'Ha Noi', '0912113113', 1, 1);
INSERT INTO student (student_name, address, `status`, class_id)
VALUES ('Hoa', 'Hai phong', 1, 1);
INSERT INTO student (student_name, address, phone, `status`, class_id)
VALUES ('Manh', 'HCM', '0123123123', 0, 2);

INSERT INTO subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);
       
INSERT INTO mark (sub_id, student_id, mark, exam_times)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (3, 1, 12, 1);
SELECT * FROM student WHERE (student_name like 'H%');
SELECT * FROM  class where start_date > "2008-11-30" ;
SELECT * FROM subject WHERE (creadit between 3 and 5);
UPDATE student set class_id = 2 WHERE  student_id = 1 ;
SELECT student.student_name , subject.sub_name , mark.mark FROM student , subject , mark WHERE subject.sub_id = mark.mark_id AND mark.student_id = student.student_id;