CREATE TABLE Tutor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255),
    contato VARCHAR(255),
    animal_associado VARCHAR(255),
    nome_do_pet VARCHAR(255)
);


CREATE TABLE Cachorro (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(255) NOT NULL,
                          raca VARCHAR(255),
                          genero VARCHAR(10),
                          idade INT,
                          vacinado BOOLEAN,
                          tutor_id BIGINT,
                          origem VARCHAR(255),
                          historico TEXT,
                          FOREIGN KEY (tutor_id) REFERENCES Tutor(id)
);

CREATE TABLE ong (
                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                     nome VARCHAR(255) NOT NULL,
                     quantidade_funcionarios INT,
                     parcerias VARCHAR(255),
                     contato VARCHAR(255),
                     registro_adocao_resgate VARCHAR(255),
                     endereco VARCHAR(255)
);

CREATE TABLE veterinario (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             agendamentos VARCHAR(255),
                             numero_crmv VARCHAR(255),
                             especialidade VARCHAR(255),
                             nome VARCHAR(255),
                             clinica_veterinaria_id BIGINT,
                             FOREIGN KEY (clinica_veterinaria_id) REFERENCES clinica_veterinaria(id)
);





INSERT INTO Tutor (nome, endereco, contato, animal_associado, nome_do_pet)
VALUES ('João', 'Rua A, 123', 'joao@example.com', 'Cachorro', 'Rex');
INSERT INTO Tutor (nome, endereco, contato, animal_associado, nome_do_pet)
VALUES ('Maria', 'Rua B, 456', 'maria@example.com', 'Cachorro', 'Thor');



INSERT INTO Cachorro (nome, raca, genero, idade, vacinado, tutor_id, origem, historico)
VALUES ('Rex', 'Labrador', 'Macho', 3, true, 1, 'Canil XYZ', 'Histórico de vacinas e saúde');
INSERT INTO Cachorro (nome, raca, genero, idade, vacinado, tutor_id, origem, historico)
VALUES ('Luna', 'Poodle', 'Fêmea', 2, true, 1, 'Criador ABC', 'Histórico de vacinas e saúde');
INSERT INTO Cachorro (nome, raca, genero, idade, vacinado, tutor_id, origem, historico)
VALUES ('Thor', 'Golden Retriever', 'Macho', 1, false, 2, 'Canil DEF', 'Histórico de vacinas e saúde');
INSERT INTO Cachorro (nome, raca, genero, idade, vacinado, tutor_id, origem, historico)
VALUES ('Bela', 'Shih Tzu', 'Fêmea', 4, true, 2, 'Criador GHI', 'Histórico de vacinas e saúde');

INSERT INTO ong (nome, quantidade_funcionarios, parcerias, contato, registro_adocao_resgate, endereco)
VALUES
    ('ONG A', 20, 'Parceria 1, Parceria 2', 'contato@onga.com', 'Registro 1', 'Rua A, 123'),
    ('ONG B', 15, 'Parceria 3, Parceria 4', 'contato@ongb.com', 'Registro 2', 'Rua B, 456');

INSERT INTO veterinario (agendamentos, numero_crmv, especialidade, nome, clinica_veterinaria_id)
VALUES
    ('Agendamento 1, Agendamento 2', '12345', 'Clínica Geral', 'Veterinário 1', 1),
    ('Agendamento 3, Agendamento 4', '67890', 'Especialidade X', 'Veterinário 2', 2);
