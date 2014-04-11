DROP TABLE IF EXISTS User;
CREATE TABLE User (
  id int primary key auto_increment NOT NULL,
  name VARCHAR(255) NOT NULL,
  nickname VARCHAR(255),
  phone_number VARCHAR(25) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password_id int NOT NULL,
  CONSTRAINT user_unique_id UNIQUE(id),
  CONSTRAINT user_unique_name UNIQUE(name),
  CONSTRAINT user_unique_email UNIQUE(email),
  CONSTRAINT user_unique_password_id UNIQUE(password_id)
);

DROP TABLE IF EXISTS Password;
CREATE TABLE Password (
  id int primary key auto_increment NOT NULL,
  user_id int,
  hash VARCHAR(255),
  CONSTRAINT password_unique_id UNIQUE(id)
);

DROP TABLE IF EXISTS Event2Users;
CREATE TABLE Event2Users (
  id int primary key auto_increment NOT NULL,
  event_id int not null,
  user_id int,
  CONSTRAINT event2users_unique_id UNIQUE(id)
);


DROP TABLE IF EXISTS Event;
CREATE TABLE Event (
  id int primary key auto_increment NOT NULL,
  date datetime not null,
  owner_id int not null,
  location VARCHAR(255) NOT NULL,
  motto VARCHAR(255),
  description VARCHAR(255) NOT NULL,
  CONSTRAINT event_unique_id UNIQUE(id)
);

ALTER TABLE User ADD FOREIGN KEY (password_id) REFERENCES Password(id);
ALTER TABLE Password ADD FOREIGN KEY (user_id) REFERENCES User(id);
ALTER TABLE Event2Users ADD FOREIGN KEY (event_id) REFERENCES Event(id);
ALTER TABLE Event2Users ADD FOREIGN KEY (user_id) REFERENCES User(id);
ALTER TABLE Event ADD FOREIGN KEY (owner_id) REFERENCES User(id);
