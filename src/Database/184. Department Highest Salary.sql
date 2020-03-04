Create table If Not Exists Employee184 (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table If Not Exists Department184 (Id int, Name varchar(255));
Truncate table Employee184;
insert into Employee184 (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee184 (Id, Name, Salary, DepartmentId) values ('2', 'Jim', '90000', '1');
insert into Employee184 (Id, Name, Salary, DepartmentId) values ('3', 'Henry', '80000', '2');
insert into Employee184 (Id, Name, Salary, DepartmentId) values ('4', 'Sam', '60000', '2');
insert into Employee184 (Id, Name, Salary, DepartmentId) values ('5', 'Max', '90000', '1');
Truncate table Department184;
insert into Department184 (Id, Name) values ('1', 'IT');
insert into Department184 (Id, Name) values ('2', 'Sales');

select a.DepartmentName Department, b.Name Employee184, b.Salary Salary from
    (select b.Id DepartmentId, b.Name DepartmentName, max(a.Salary) Salary
     from Employee184 a join Department184 b on a.DepartmentId = b.Id
     group by DepartmentId) a
join Employee184 b on a.DepartmentId = b.DepartmentId and a.Salary = b.Salary