select * from department;
select * from projects;
select * from contactstype;
select * from employee;
select * from employeecontacts;
select * from employeeprojects;

insert into employeecontacts values(10002, 1, '7439469759');

select distinct employeeid, contactstypeid from employeecontacts;

insert into employee values(10004, 'Samar', 'Patanaik', 'M', 'samar_patanaik@ofc.com', null, 26, 800000.00, to_date('10092012', 'DDMMYYYY'), 10002, 2);
insert into employee values(10005, 'Apratim', 'Saha', 'M', 'apratim_saha@ofc.com', null, 25, 1600000.00, to_date('10092012', 'DDMMYYYY'), 10003, 3);
insert into employee values(10006, 'Brajendra', 'Swain', 'M', 'brajendra_swain@ofc.com', null, 25, 1000000.00, to_date('10092012', 'DDMMYYYY'), 10003, 3);

select upper(firstname), lower(lastname) from employee where not firstname in ('Kaushik') and lastname in ('Sahu', 'Saha');
select (firstname || ' ' || lastname) as name from employee where firstname like 'A%' and upper(lastname) like '%A';  -- % is an escape-character for mulitple characters
select (firstname || ' ' || lastname) as name from employee where lastname not like '_a%';  -- _ is an escape-character for single character

select min(salary), max(salary), sum(salary), avg(salary) from employee;

update employeeprojects set duration = null where duration < 10;

select count(*) from employeeprojects;  -- count(*) - returns total no. of records
select count(duration) from employeeprojects;  -- count(columnname) - returns total no. of not null records
select count(distinct duration) from employeeprojects;  -- count(distinct columnname) - returns total no. of distinct not null records

insert into employee values(10007, 'Brajendra', 'Kumar', 'M', 'brajendra_kumar@ofc.com', null, 23, 1000000.00, to_date('10092012', 'DDMMYYYY'), 10003, 3);
insert into employee values(10008, 'Sipak', 'Mishra', 'M', 'sipak_mishra@ofc.com', null, 27, 1100000.00, to_date('10092012', 'DDMMYYYY'), 10001, 1);

select firstname, lastname from employee order by firstname asc, lastname desc; -- order by - sorts the records while displaying, by default order is asc

update employee set dateofjoining = to_date('20102012','DDMMYYYY') where id > 10004;

select dateofjoining, max(salary) from employee group by dateofjoining; -- group by is used to aggregate data into a certain group
select departmentid, avg(salary) from employee group by departmentid having departmentid < 3; -- having condition - filters the group by result, and it has to be based only on some columns (or aggregated columns) that appear in group by list
select departmentid, avg(salary) from employee group by departmentid having avg(salary) > 800000;

select * from employee cross join department; -- m * n rows - i.e., 1...m with 1 ..... 1...m with n
select e.id, e.firstname, d.name from employee e inner join department d on e.departmentid = d.id;  -- m * 1 rows - i.e., 1...m with corresponding 1...n. If we write only join - it signifies inner join
select e.id, e.firstname, d.name from employee e inner join department d on e.departmentid = d.id and d.id in (1, 2);  -- m * 1 rows with condition - i.e., <= m rows. At least N - 1 conditions are required to join N tables
select e.id, e.firstname, d.name from employee e left outer join department d on e.departmentid = d.id and d.id in (1, 2);  -- m rows with condition, returns all the records from the table on left side of join. If we write only left join - it signifies left outer join
select e.id, e.firstname, d.name from employee e right outer join department d on e.departmentid = d.id and d.id in (1, 2);  -- <= m rows with condition + <= n rows, returns all the records from the table on right side of join. If we write only right join - it signifies right outer join
select e.firstname || ' ' || e.lastname as employee, m.firstname || ' ' || m.lastname from employee e inner join employee m on e.managerid = m.id;  -- self join - <= m rows with condition, returns all records from the same table which satisfies the join condition

-- sub-query - a query within a query - can be used in select, from, where, and having clauses
-- independent sub-query - inner query is executed first and the results are stored, after that outer query runs on the stored results
select departmentid from employee group by departmentid having sum(salary) = (select max(sum(salary)) from employee group by departmentid); 
select firstname || ' ' || lastname as "Highest paid employee" from employee where salary = (select max(salary) from employee); 
-- correlated sub-query - inner query refers to a table in the from clause of the outer query and inner query is executed separately for each row of the outer query, i.e., sql performs a sub-query over and over agian - once for each row of outer query
select departmentid, firstname || ' ' || lastname as employee, emailid, salary from employee e1 where salary >= (select avg(salary) from employee e2 where e1.departmentid = e2.departmentid) order by departmentid;

-- SQL interview queries -
select firstname || ' ' || lastname as "3rd Highest paid employees", salary from employee where salary = (select max(salary) from employee where salary < (select max(salary) from employee where salary < (select max(salary) from employee))); -- using multiple sub-queries
select * from(select firstname || ' ' || lastname as "3rd Highest paid employee", salary, row_number() over (order by salary desc) as rownumber from employee order by firstname || ' ' || lastname) where rownumber = 3;  -- returns the 3rd highgest paid employee, even if with same salaries
select * from(select firstname || ' ' || lastname as "3rd Highest paid employees", salary, dense_rank() over (order by salary desc) as ranking from employee order by firstname || ' ' || lastname) where ranking = 3;  -- returns the 3rd highest paid employees, with distinct salaries
/*Data :- insert into table values ('A'),('A'),('A'),('B'),('B'),('C'),('C');
Row_Number() - This function will assign a unique id to each row returned from the query.
Col_Value	RowID
        A	1
        A	2
        A	3
        B	4
        B	5
        C	6
        C	7

Rank() - This function will assign a unique number to each distinct row, but it leaves a gap between the groups.
Col_Value	RowID
        A	1
        A	1
        A	1
        B	4
        B	4
        C	6
        C	6

Dense_Rank() - This function is similar to Rank with only difference, this will not leave gaps between groups.
Col_Value	RowID
        A	1
        A	1
        A	1
        B	2
        B	2
        C	3
        C	3
*/
