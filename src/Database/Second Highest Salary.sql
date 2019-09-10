# Create table If Not Exists Employee (Id int, Salary int);
# Truncate table Employee;
# insert into Employee (Id, Salary) values ('1', '100');
# insert into Employee (Id, Salary) values ('2', '200');
# insert into Employee (Id, Salary) values ('3', '300');

# Write your MySQL query statement below

# 测试用例中可以发现当数据只有一条时要求返回null，因此下面一条语句是不符合要求的
# SELECT Salary as SecondHighestSalary FROM Employee ORDER BY Salary DESC LIMIT 1,1

SELECT CASE
           WHEN COUNT(*) >= 1 THEN
               MAX(a.Salary)
           ELSE NULL END AS SecondHighestSalary
FROM (SELECT Salary FROM employee WHERE Salary <> (SELECT MAX(Salary) FROM employee)) a;
