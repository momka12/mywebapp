INSERT INTO users(name, lastname, city, email, password, enabled) VALUES ('petrik', 'ivanov', 'dnepr', 'petr@mail.com', '123', 'true')

INSERT INTO users(name, lastname, city, email, password, enabled) VALUES ('maria', 'forma', 'odessa', 'maria@mail.com', '123', 'true')

INSERT INTO users(name, lastname, city, email, password, enabled) VALUES ('romka', 'fich', 'ffsdfs', 'romka@mail.com', '123', 'true')

INSERT INTO users(name, lastname, city, email, password, enabled) VALUES ('admin', 'fich', 'ffsdfs', 'admin@mail.com', '123', 'true')
INSERT INTO users(name, lastname, city, email, password, enabled) VALUES ('rest', 'fich', 'ffsdfs', 'rest@mail.com', '123', 'true')
INSERT INTO users(name, lastname, city, email, password, enabled) VALUES ('user', 'fich', 'ffsdfs', 'user@mail.com', '123', 'true')

INSERT INTO roles(name) VALUES ('ROLE_ADMIN')
INSERT INTO roles(name) VALUES ('ROLE_REST')
INSERT INTO roles(name) VALUES ('ROLE_USER')

INSERT INTO roles_users(roles_id, users_id) VALUES (1,4)
INSERT INTO roles_users(roles_id, users_id) VALUES (2,5)
INSERT INTO roles_users(roles_id, users_id) VALUES (3,6)
INSERT INTO roles_users(roles_id, users_id) VALUES (3,1)
INSERT INTO roles_users(roles_id, users_id) VALUES (3,2)
INSERT INTO roles_users(roles_id, users_id) VALUES (3,3)


