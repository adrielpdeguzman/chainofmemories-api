insert into users(username, password, email, first_name, last_name) values ('adrielpdeguzman', '$2a$06$Ecr63ZuthbumsqG4PV0Q6.zHT/sdtDuJ/QLOtR1qtCN50AZd8Y6fS', 'adrielpdeguzman@icloud.com', 'Adriel', 'de Guzman');
insert into users(username, password, email, first_name, last_name) values ('monaliceperez', '$2a$06$C.BCyUYMNwqPYcPVOvIHR.0x8eauKgik0YxyK/yxCuSojsvCGGMvO', 'monaliceperez@icloud.com', 'Monalice', 'Perez');
insert into users(username, password, email, first_name, last_name) values ('test3', 'test3', 'test3@test3.test3', 'Test3', 'Test3');

insert into journals(user_id, publish_date, volume, day, contents, special_events) values (1, '2013-12-07', 1, 1, 'Test 1', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (1, '2014-01-08', 2, 31, 'Test 2', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (2, '2013-12-07', 1, 1, 'Test 3', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (2, '2014-01-08', 2, 31, 'Test 4', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (2, '2014-01-10', 2, 33, 'Test 6', 'Lorem ipsum dolor');
insert into journals(user_id, publish_date, volume, day, contents, special_events) values (2, '2014-01-09', 2, 32, 'Test 5', 'Lorem ipsum dolor');

-- OAuth2 Tables
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);

create table oauth_code (
  code VARCHAR(256), authentication LONGVARBINARY
);