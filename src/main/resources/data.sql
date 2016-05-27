insert into users(username, password, email, first_name, last_name) values ('adrielpdeguzman', '$2a$06$Ecr63ZuthbumsqG4PV0Q6.zHT/sdtDuJ/QLOtR1qtCN50AZd8Y6fS', 'adrielpdeguzman@icloud.com', 'Adriel', 'de Guzman');
insert into users(username, password, email, first_name, last_name) values ('monaliceperez', '$2a$06$C.BCyUYMNwqPYcPVOvIHR.0x8eauKgik0YxyK/yxCuSojsvCGGMvO', 'monaliceperez@icloud.com', 'Monalice', 'Perez');

insert into journals(user_id, publish_date, volume, day, contents, special_events) values (1, '2013-12-07', 1, 1, 'Test 1', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (1, '2014-01-08', 2, 31, 'Test 2', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (2, '2013-12-07', 1, 1, 'Test 3', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (2, '2014-01-08', 2, 31, 'Test 4', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (2, '2014-01-10', 2, 33, 'Test 6', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (2, '2014-01-09', 2, 32, 'Test 5', 'Lorem ipsum dolor');