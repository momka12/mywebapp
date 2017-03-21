DROP TABLE IF EXISTS usersJAVA.dbo.users

CREATE TABLE usersJAVA.dbo.users (
  id INT PRIMARY KEY NOT NULL,
  name VARCHAR(20) NOT NULL,
  lastname VARCHAR(25) NOT NULL,
  city VARCHAR(25),
  email VARCHAR(35)
);
CREATE UNIQUE INDEX users_id_uindex ON users (id);
CREATE UNIQUE INDEX users_email_uindex ON users (email);

INSERT INTO users VALUES ('petrik', 'ivanov', 'dnepr', 'petr@mail.com');
INSERT INTO users VALUES ('maria', 'forma', 'odessa', 'maria@mail.com');
INSERT INTO users VALUES ('romka', 'fich', 'dnepr', 'romka@mail.com');