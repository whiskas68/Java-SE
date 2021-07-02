create table `inventory` (
id varchar(255) not null,
name varchar(255) not null,
count int(11) not null
) engine=innodb default charset=utf8mb4;

insert into inventory values ('1','a',1);
insert into inventory values ('2','b',2);
insert into inventory values ('3','c',3);