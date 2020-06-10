INSERT INTO users_credentials(id, username, password, email) VALUES (1, 'fredmosc', '$2a$10$bJk5prDUL0fWuhFxM68Ae.ABOC/QpLBOeqU24oZvrf0C2yPsVFRVS', 'test01@email.com')
INSERT INTO users_credentials(id, username, password, email) VALUES (2, 'fredmosc2', '$2a$10$bJk5prDUL0fWuhFxM68Ae.ABOC/QpLBOeqU24oZvrf0C2yPsVFRVS', 'teste02@email.com')

INSERT INTO credentials_roles(credentials_id, role) VALUES(1, 'ADMIN')
INSERT INTO credentials_roles(credentials_id, role) VALUES(2, 'USER')