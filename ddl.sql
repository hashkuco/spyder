create database spider;
use spider;
create table films(
	id int primary key auto_increment;
	title varchar(140);
	poster varchar(140);
	star double;
	rating varchar(140);
	quote varchar(140);
	 director varchar(80),
    actor varchar(80),
    year  int(40),
    country varchar(40)


)