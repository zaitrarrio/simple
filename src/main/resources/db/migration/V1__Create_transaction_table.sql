create table trans (
    id int not null,
    name varchar(100) not null,
    amount decimal(19,4) not null,
    creation_date timestamp default CURRENT_TIMESTAMP
);