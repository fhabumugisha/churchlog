create table task(
                     id  bigserial primary key ,
                     title varchar,
                     description varchar NOT NULL ,
                     service varchar ,
                     task_date date NOT NULL,
                     type varchar not null ,
                     persons varchar ,
                     duration bigint,
                     user_name varchar not null
)