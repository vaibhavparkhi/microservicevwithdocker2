SELECT * FROM sql_jpa_tut.course;
insert into sql_jpa_tut.course(id, name, updated_date, created_date) values(10001, 'JPA in 50 steps', sysdate(), sysdate());
insert into sql_jpa_tut.course(id, name, updated_date, created_date) values(10002, 'JAVA in 50 steps', sysdate(), sysdate());
insert into sql_jpa_tut.course(id, name, updated_date, created_date) values(10003, 'Spring in 50 steps', sysdate(), sysdate());
insert into sql_jpa_tut.course(id, name, updated_date, created_date) values(10004, 'React in 50 steps', sysdate(), sysdate());
insert into sql_jpa_tut.course(id, name, updated_date, created_date) values(10005, 'Docker in 50 steps', sysdate(), sysdate());

SELECT * FROM sql_jpa_tut.student;
insert into sql_jpa_tut.student(id, name, passport_id) values(20001, 'Vaibhav Parkhi',40001);
insert into sql_jpa_tut.student(id, name, passport_id) values(20002, 'Dane', 40002);
insert into sql_jpa_tut.student(id, name, passport_id) values(20003, 'Bunny', 40003);


SELECT * FROM sql_jpa_tut.review;
insert into sql_jpa_tut.review(id, rating, description, course_id) values(30001, '8', 'Great Course', 10001);
insert into sql_jpa_tut.review(id, rating, description,course_id) values(30002, '6', 'Good Course', 10001);
insert into sql_jpa_tut.review(id, rating, description, course_id) values(30003, '7','Excellent Course', 10003);

SELECT * FROM sql_jpa_tut.passport;
insert into sql_jpa_tut.passport(id, number) values(40001, 'US123456');
insert into sql_jpa_tut.passport(id, number) values(40002, 'US456766');
insert into sql_jpa_tut.passport(id, number) values(40003, 'U0765543');

insert into sql_jpa_tut.student_course(student_id, course_id) values(20001, 10001);
insert into sql_jpa_tut.student_course(student_id, course_id) values(20002, 10001);
insert into sql_jpa_tut.student_course(student_id, course_id) values(20003, 10001);
insert into sql_jpa_tut.student_course(student_id, course_id) values(20001, 10003);



select * from sql_jpa_tut.student s, sql_jpa_tut.passport p where s.passport_id=p.id;