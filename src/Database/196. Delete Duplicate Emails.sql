# create table Person196 (Id int primary key , Email varchar(255));
# insert into Person196 values (1 , 'john@example.com'), (2, 'bob@example.com'), (3, 'john@example.com');
# drop table if exists person_tmp;
# create table if not exists person_tmp like person196;
# truncate table person_tmp;
# insert into person_tmp select Id, Email from person196 group by Email;
# truncate table person196;
# insert into person196 select * from person_tmp;

delete p1 from Person196 p1, Person196 p2 where p1.Id > p2.Id and p1.Email = p2.Email