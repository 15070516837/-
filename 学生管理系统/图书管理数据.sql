create database Student
go
use Student
go

create table cj
(
	ID int primary key identity(1,1),
	language float not null,
	mathe float not null,
	english float not null,
	sum float not null,

)
go
create table Student
(
	cj int primary key identity(1,1) references cj(ID),
	name varchar(20) not null,

)
go
select * from Student s,cj c where s.cj=c.ID 
