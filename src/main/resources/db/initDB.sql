DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(15),
  lastname VARCHAR(20),
  city VARCHAR(30),
  email VARCHAR(25) UNIQUE
);

INSERT INTO users VALUES (NULL, 'NICK', 'DALLAS', 'DNIPRO', 'user@gmail.com');
INSERT INTO users VALUES (NULL, 'ANGELA', 'HIKE', 'KYIV', 'ang@yahoo.com');
