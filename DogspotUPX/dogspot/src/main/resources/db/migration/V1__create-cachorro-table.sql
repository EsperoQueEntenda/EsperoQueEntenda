CREATE TABLE Tutor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255)
);

CREATE TABLE Cachorro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    raca VARCHAR(255),
    genero VARCHAR(10),
    idade INT,
    vacinado BOOLEAN,
    tutor_id BIGINT,
    FOREIGN KEY (tutor_id) REFERENCES Tutor(id)
);



INSERT INTO Tutor (nome, endereco) VALUES ('João', 'Rua A, 123');
INSERT INTO Tutor (nome, endereco) VALUES ('Maria', 'Rua B, 456');


INSERT INTO Cachorro (nome, raca, genero, idade, vacinado, tutor_id) VALUES ('Rex', 'Labrador', 'Macho', 3, true, 1);
INSERT INTO Cachorro (nome, raca, genero, idade, vacinado, tutor_id) VALUES ('Luna', 'Poodle', 'Fêmea', 2, true, 1);
INSERT INTO Cachorro (nome, raca, genero, idade, vacinado, tutor_id) VALUES ('Thor', 'Golden Retriever', 'Macho', 1, false, 2);
INSERT INTO Cachorro (nome, raca, genero, idade, vacinado, tutor_id) VALUES ('Bela', 'Shih Tzu', 'Fêmea', 4, true, 2);