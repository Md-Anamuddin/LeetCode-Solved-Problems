# Write your MySQL query statement below
SELECT d.name as Department, e.name as Employee, e.salary as Salary
FROM Employee e
JOIN Department d
ON e.departmentId = d.id
WHERE e.salary = (
    SELECT MAX(e2.salary)
    FROM Employee e2
    WHERE e2.departmentId = e.departmentId
);