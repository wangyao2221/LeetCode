Create table If Not Exists Employee181 (Id int, Name varchar(255), Salary int, ManagerId int);
Truncate table Employee181;
insert into Employee181 (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3');
insert into Employee181 (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4');
insert into Employee181 (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', NULL);
insert into Employee181 (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', NULL);

# 可能英文数据量太小，以下三条SQL执行效率无明显差异
# The following three SQL statements are not significantly different due to the small amount of data

select a.Name Employee from Employee181 a join Employee181 b on a.ManagerId = b.Id and a.Salary > b.Salary;

select name Employee from
(select a.Name name, a.Salary salary, b.Salary salary_ from Employee181 a join Employee181 b on a.ManagerId = b.Id) tmp
where salary > salary_;

select a.Name Employee from Employee181 a join Employee181 b on a.ManagerId = b.Id where a.Salary > b.Salary;