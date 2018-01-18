-- Create Table
create table parentmapping
(
   id integer not null auto_increment,
   child_id varchar(255) not null,
   parent_id varchar(255) not null,
   primary key(id)
);

-- Drop Table
drop table parentmapping;
