create table accounts (
  id serial primary key,
  username varchar(256) not null unique,
  password varchar(256) not null
);