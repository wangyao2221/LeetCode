create table Person196 (Id int primary key , Email varchar(255));
create view view_person as select distinct * from Person;
truncate table person;
insert into Person select * from view_person;