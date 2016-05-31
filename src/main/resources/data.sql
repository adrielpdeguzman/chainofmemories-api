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
drop table if exists oauth_client_details;
create table oauth_client_details (
  client_id VARCHAR(255) PRIMARY KEY,
  resource_ids VARCHAR(255),
  client_secret VARCHAR(255),
  scope VARCHAR(255),
  authorized_grant_types VARCHAR(255),
  web_server_redirect_uri VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(255)
);
 
drop table if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(255),
  token LONGVARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255)
);
 
drop table if exists oauth_access_token;
create table oauth_access_token (
  token_id VARCHAR(255),
  token LONGVARBINARY,
  authentication_id VARCHAR(255) PRIMARY KEY,
  user_name VARCHAR(255),
  client_id VARCHAR(255),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(255)
);
 
drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
  token_id VARCHAR(255),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);
 
drop table if exists oauth_code;
create table oauth_code (
  code VARCHAR(255), authentication LONGVARBINARY
);
 
drop table if exists oauth_approvals;
create table oauth_approvals (
    userId VARCHAR(255),
    clientId VARCHAR(255),
    scope VARCHAR(255),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);
 
drop table if exists ClientDetails;
create table ClientDetails (
  appId VARCHAR(255) PRIMARY KEY,
  resourceIds VARCHAR(255),
  appSecret VARCHAR(255),
  scope VARCHAR(255),
  grantTypes VARCHAR(255),
  redirectUrl VARCHAR(255),
  authorities VARCHAR(255),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(255)
);