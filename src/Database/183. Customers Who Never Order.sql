Create table If Not Exists Customers (Id int, Name varchar(255));
Create table If Not Exists Orders (Id int, CustomerId int);
Truncate table Customers;
insert into Customers (Id, Name) values ('1', 'Joe');
insert into Customers (Id, Name) values ('2', 'Henry');
insert into Customers (Id, Name) values ('3', 'Sam');
insert into Customers (Id, Name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (Id, CustomerId) values ('1', '3');
insert into Orders (Id, CustomerId) values ('2', '1');
select Name Customers from Customers where Id not in (select CustomerId from Orders);

# 注意：直接在left join后面加where就是在join后的表中去筛选，因此不用去做临时表
# select Name Customers from (select a.Name Name, b.Id OrderId from Customers a left join Orders b on a.Id = b.CustomerId) tmp where OrderId is NULL
select a.Name Customers from Customers a left join Orders b on a.Id = b.CustomerId where b.Id is null