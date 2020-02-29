# select name Employee from
# (select a.Name name, a.Salary salary, b.Salary salary_ from Employee a join Employee b on a.ManagerId = b.Id) tmp
# where salary > salary_
Create table If Not Exists Employee (Id int, Name varchar(255), Salary int, ManagerId int);
Truncate table Employee;
insert into Employee (Id, Name, Salary, ManagerId) values ('1', 'Joe', '70000', '3');
insert into Employee (Id, Name, Salary, ManagerId) values ('2', 'Henry', '80000', '4');
insert into Employee (Id, Name, Salary, ManagerId) values ('3', 'Sam', '60000', 'None');
insert into Employee (Id, Name, Salary, ManagerId) values ('4', 'Max', '90000', 'None');
select a.Name Employee from Employee a join Employee b on a.ManagerId = b.Id where a.Salary > b.Salary;