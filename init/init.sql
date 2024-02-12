use music;
CREATE TABLE record_label (
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(50) not null,
  UNIQUE(name)
);
INSERT INTO record_label(name) VALUES('Blackened');
INSERT INTO record_label(name) VALUES('Warner Bros');
INSERT INTO record_label(name) VALUES('Universal');
INSERT INTO record_label(name) VALUES('MCA');
INSERT INTO record_label(name) VALUES('Elektra');
INSERT INTO record_label(name) VALUES('Capitol');
CREATE TABLE artist (
  id int AUTO_INCREMENT PRIMARY KEY,
  recordId int not null references record_label,
  name 	varchar(50) not null,
  UNIQUE(recordId, name)
);
INSERT INTO Artist(recordId, name) VALUES(1,'Metallica');
INSERT INTO Artist(recordId, name) VALUES(1,'Megadeth');
INSERT INTO Artist(recordId, name) VALUES(1,'Anthrax');
INSERT INTO Artist(recordId, name) VALUES(2,'Eric Clapton');
INSERT INTO Artist(recordId, name) VALUES(2,'ZZ Top');
INSERT INTO Artist(recordId, name) VALUES(2,'Van Halen');
INSERT INTO Artist(recordId, name) VALUES(3,'Lynyrd Skynyrd');
INSERT INTO Artist(recordId, name) VALUES(3,'AC/DC');
INSERT INTO Artist(recordId, name) VALUES(6,'The Beatles');
