create table cities (
                        id serial primary key,
                        name varchar(2000)
);
insert into cities values (1, 'Минск');
insert into cities values (2, 'Москва');
insert into cities values (3, 'Лондон');
insert into cities values (4, 'Кейптаун');
insert into cities values (5, 'Оттава');
commit;