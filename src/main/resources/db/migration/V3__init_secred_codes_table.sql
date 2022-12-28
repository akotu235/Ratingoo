drop table if exists secret_codes;
create table secret_codes(
    secret_code varchar(100) primary key,
    active bit
);