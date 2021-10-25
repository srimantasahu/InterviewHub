-- drop table employee; -- without cascade constraints - throws SQL Error - unique/primary keys in table referenced by foreign keys
drop table employee cascade constraints;  -- drops all referential intergrity constraints of child tables that refers to primary and unique keys in the dropped table 
drop table projects cascade constraints;  -- and keeps the previous entries in child tables as-is (with dropped parent table values too)
drop table employeeprojects;
drop table employeecontacts;
drop table contactstype;
drop table department;


create table department(id number(2) constraint "department_pk" primary key, name varchar2(30), location varchar2(50));

insert into department(id, name) values(1, 'ECS');
insert into department(id, name) values(2, 'MFG');
insert into department(id, name) values(3, 'FSI');


create table projects(id number(5) constraint "projects_pk" primary key, name varchar2(30), location varchar2(30), startdate date default current_date, departmentid number(2) constraint "pro_department_fk" references department(id) on delete cascade);

insert into projects(id, name, startdate, departmentid) values(101, 'Unwire', to_date('09102012', 'DDMMYYYY'), 1);
insert into projects(id, name, startdate, departmentid) values(102, 'CISCO', to_date('06012009', 'DDMMYYYY'), 2);
insert into projects(id, name, startdate, departmentid) values(103, 'BOA', to_date('02012008', 'DDMMYYYY'), 3);
insert into projects(id, name, startdate, departmentid) values(104, 'BT', to_date('06052010', 'DDMMYYYY'), 1);

-- delete from department; -- if child table's fk has on delete cascade then it successfully deletes all record from the parent and corresponding child records too
                        -- else if child tables are empty (no records), then it successfully deletes the parent table records
                        -- else throw SQL Error - integrity constraint (SYSTEM.pro_department_fk) violated - child record found


create table contactstype(id number(1), contactstype varchar2(10), description varchar2(30));

alter table contactstype add constraint "contactstype_pk" primary key(id);
alter table contactstype modify(contactstype varchar2(10) constraint "contactstype_nn" not null);
alter table contactstype drop(description);
alter table contactstype add(description varchar2(30));

insert into contactstype values(1, 'Phone', 'Phone number');
insert into contactstype values(2, 'Email', 'Email Id');


create table employee(id number(8) constraint "employee_pk" primary key, firstname varchar2(30), lastname varchar2(30), gender varchar2(1), emailid varchar2(50) not null, address varchar2(100), age number(2), salary NUMBER(10,2), dateofjoining date default current_date, managerId number(8) constraint "emp_mgr_fk" references employee(id), departmentid number(2) constraint "emp_department_fk" references department(id));

alter table employee drop constraint "emp_mgr_fk";
alter table employee drop primary key;
alter table employee add constraint "employee_pk" primary key(id);
alter table employee add constraint "emp_mgr_fk" foreign key(managerid) references employee(id);
alter table employee drop constraint "emp_department_fk";
alter table employee add constraint "emp_department_fk" foreign key(departmentid) references department(id);
alter table employee modify(gender varchar2(1) constraint "employee_gender_ck" check(gender in ('M','F')));

insert into employee values(10001, 'Srimanta', 'Sahu', 'M', 'srimanta_sahu@ofc.com', null, 26, 1000000.00, to_date('10092012', 'DDMMYYYY'), null, 1);
insert into employee values(10002, 'Amit', 'Gouda', 'M', 'amit_gouda@ofc.com', null, 26, 600000.00, to_date('10092012', 'DDMMYYYY'), null, 2);
insert into employee values(10003, 'Kaushik', 'Sahu', 'M', 'kaushik_sahu@ofc.com', null, 26, 500000.00, to_date('10092012', 'DDMMYYYY'), null, 3);

alter table employee drop constraint "emp_department_fk";
delete from department; -- emp_department_fk - doesn't have on delete cascade, so we need to drop the constraints first, then we can delete the records
-- alter table employee add constraint "emp_department_fk" foreign key(departmentid) references department(id); -- throws SQL Error with cause - an alter table validating constraint failed because the table has child records, if table (employee) is empty, then successfully adds the constraint
-- alter table employee modify(departmentid number(2) constraint "emp_department_fk" references department(id));  -- throws SQL Error with cause - an alter table validating constraint failed because the table has child records, if table (employee) is empty, then successfully adds the constraint
alter table employee drop(departmentid);  -- as table (employee) is not empty, we won't be able to modify and add fk constraints, so we need to drop the column and then add it again with fk constraints
alter table employee add(departmentid number(2) constraint "emp_department_fk" references department(id));
insert into department(id, name) values(1, 'ECS');
insert into department(id, name) values(2, 'MFG');
insert into department(id, name) values(3, 'FSI');
insert into projects(id, name, startdate, departmentid) values(101, 'Unwire', to_date('09102012', 'DDMMYYYY'), 1); -- as projects table has on delete cascade for department, all the linked records will get deleted
insert into projects(id, name, startdate, departmentid) values(102, 'CISCO', to_date('06012009', 'DDMMYYYY'), 2);  -- that's why we again need to store them into the table
insert into projects(id, name, startdate, departmentid) values(103, 'BOA', to_date('02012008', 'DDMMYYYY'), 3);
insert into projects(id, name, startdate, departmentid) values(104, 'BT', to_date('06052010', 'DDMMYYYY'), 1);
update employee set departmentid = '1' where id = '10001';
update employee set departmentid = '2' where id = '10002';
update employee set departmentid = '3' where id = '10003';


create table employeecontacts(employeeid number(8) constraint "empcon_employee_nn" not null constraint "empcon_employee_fk" references employee(id), contactstypeid number(1) constraint "empcon_contactstype_nn" not null constraint "empcon_contactstype_fk" references contactstype(id), contactvalue varchar2(50), constraint "employeecontacts_pk" primary key(employeeid, contactstypeid));

insert into employeecontacts values(10001, 1, '8095334035');
insert into employeecontacts values(10001, 2, 'srimanta_sahu@yahoo.com');


create table employeeprojects(employeeid number(8) constraint "emppro_employee_nn" not null constraint "emppro_employee_fk" references employee(id), projectid number(5) constraint "emppro_projects_nn" not null constraint "emppro_projects_fk" references projects(id) on delete cascade, duration number(3), startdate date default current_date, constraint "employeeprojects_pk" primary key(employeeid, projectid));

insert into employeeprojects values(10001, 101, 11, to_date('06012013', 'DDMMYYYY'));
insert into employeeprojects values(10001, 104, 6, to_date('01032014', 'DDMMYYYY'));
insert into employeeprojects values(10002, 102, 20, to_date('01032013', 'DDMMYYYY'));

-- if emppro_projects_fk has on delete cascade

alter table employee drop constraint "emp_department_fk";
delete from department; -- emp_department_fk - doesn't have on delete cascade, so we need to drop the constraints first, then we can delete the records
-- alter table employee add constraint "emp_department_fk" foreign key(departmentid) references department(id); -- throws SQL Error with cause - an alter table validating constraint failed because the table has child records, if table (employee) is empty, then successfully adds the constraint
-- alter table employee modify(departmentid number(2) constraint "emp_department_fk" references department(id));  -- throws SQL Error with cause - an alter table validating constraint failed because the table has child records, if table (employee) is empty, then successfully adds the constraint
alter table employee drop(departmentid);  -- as table (employee) is not empty, we won't be able to modify and add fk constraints, so we need to drop the column and then add it again with fk constraints
alter table employee add(departmentid number(2) constraint "emp_department_fk" references department(id));
insert into department(id, name) values(1, 'ECS');
insert into department(id, name) values(2, 'MFG');
insert into department(id, name) values(3, 'FSI');
insert into projects(id, name, startdate, departmentid) values(101, 'Unwire', to_date('09102012', 'DDMMYYYY'), 1); -- as projects table has on delete cascade for department, all the linked records will get deleted
insert into projects(id, name, startdate, departmentid) values(102, 'CISCO', to_date('06012009', 'DDMMYYYY'), 2);  -- that's why we again need to store them into the table
insert into projects(id, name, startdate, departmentid) values(103, 'BOA', to_date('02012008', 'DDMMYYYY'), 3);
insert into projects(id, name, startdate, departmentid) values(104, 'BT', to_date('06052010', 'DDMMYYYY'), 1);
update employee set departmentid = '1' where id = '10001';
update employee set departmentid = '2' where id = '10002';
update employee set departmentid = '3' where id = '10003';
insert into employeeprojects values(10001, 101, 11, to_date('06012013', 'DDMMYYYY'));
insert into employeeprojects values(10001, 104, 6, to_date('01032014', 'DDMMYYYY'));
insert into employeeprojects values(10002, 102, 20, to_date('01032013', 'DDMMYYYY'));

-- if emppro_projects_fk doesn't have on delete cascade, then we need to drop emppro_projects_fk to delete department records as it is linked via project's id and then, we need to truncate employeeprojects to add emppro_projects_fk back to the table

drop table employeeprojects;

create table employeeprojects(employeeid number(8) constraint "emppro_employee_nn" not null constraint "emppro_employee_fk" references employee(id), projectid number(5) constraint "emppro_projects_nn" not null constraint "emppro_projects_fk" references projects(id), duration number(3), startdate date default current_date, constraint "employeeprojects_pk" primary key(employeeid, projectid));

insert into employeeprojects values(10001, 101, 11, to_date('06012013', 'DDMMYYYY'));
insert into employeeprojects values(10001, 104, 6, to_date('01032014', 'DDMMYYYY'));
insert into employeeprojects values(10002, 102, 20, to_date('01032013', 'DDMMYYYY'));

alter table employeeprojects drop constraint "emppro_projects_fk";
alter table employee drop constraint "emp_department_fk";
delete from department; -- emppro_projects_fk, emp_department_fk - doesn't have on delete cascade, so we need to drop the constraints first, then we can delete the records
-- alter table employee add constraint "emp_department_fk" foreign key(departmentid) references department(id); -- throws SQL Error with cause - an alter table validating constraint failed because the table has child records, if table (employee) is empty, then successfully adds the constraint
-- alter table employee modify(departmentid number(2) constraint "emp_department_fk" references department(id));  -- throws SQL Error with cause - an alter table validating constraint failed because the table has child records, if table (employee) is empty, then successfully adds the constraint
alter table employee drop(departmentid);  -- as table (employee) is not empty, we won't be able to modify and add fk constraints, so we need to drop the column and then add it again with fk constraints
alter table employee add(departmentid number(2) constraint "emp_department_fk" references department(id));
insert into department(id, name) values(1, 'ECS');
insert into department(id, name) values(2, 'MFG');
insert into department(id, name) values(3, 'FSI');
insert into projects(id, name, startdate, departmentid) values(101, 'Unwire', to_date('09102012', 'DDMMYYYY'), 1); -- as projects table has on delete cascade for department, all the linked records will get deleted
insert into projects(id, name, startdate, departmentid) values(102, 'CISCO', to_date('06012009', 'DDMMYYYY'), 2);  -- that's why we again need to store them into the table
insert into projects(id, name, startdate, departmentid) values(103, 'BOA', to_date('02012008', 'DDMMYYYY'), 3);
insert into projects(id, name, startdate, departmentid) values(104, 'BT', to_date('06052010', 'DDMMYYYY'), 1);
update employee set departmentid = '1' where id = '10001';
update employee set departmentid = '2' where id = '10002';
update employee set departmentid = '3' where id = '10003';
-- alter table employeeprojects drop(projectid);  -- throws SQL Error - column is referenced in a multi-column constraint - can't drop because it is a part of the primary key constraint
truncate table employeeprojects;  -- as we can't drop the column (projectid) due to multi-column constraint, we have to truncate the table to delete all records inorder to add the emppro_projects_fk back to the table
alter table employeeprojects modify(projectid number(5) constraint "emppro_projects_fk" references projects(id) on delete cascade); -- added on delete cascade on emppro_projects_fk in employeeprojects table, to delete the employeeprojects records once the department/project is deleted
insert into employeeprojects values(10001, 101, 10, to_date('06012013', 'DDMMYYYY'));
insert into employeeprojects values(10001, 104, 6, to_date('01032014', 'DDMMYYYY'));
insert into employeeprojects values(10002, 102, 20, to_date('01032013', 'DDMMYYYY'));
commit; -- commits the above DML statements (DDL statements are auto committed)

insert into employeeprojects values(10001, 102, 3, to_date('01062014', 'DDMMYYYY'));
insert into employeeprojects values(10003, 103, 10, to_date('01012014', 'DDMMYYYY'));
rollback; -- rolls back the above DML statements

insert into employeeprojects values(10001, 102, 3, to_date('01062014', 'DDMMYYYY'));
insert into employeeprojects values(10003, 103, 10, to_date('01012014', 'DDMMYYYY'));
alter table department drop(location);  -- an explicit commit for above DML statements is not required as a DDL statement on completion calls an implicit commit.
rollback; -- as with the implicit commit, above DML statements are already committed to the database, so the rollback statement will have no effects
alter table department add(location varchar2(50));

-- add for indexes - 