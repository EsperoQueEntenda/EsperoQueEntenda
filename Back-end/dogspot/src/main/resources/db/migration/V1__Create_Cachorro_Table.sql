CREATE TABLE Cachorro (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          nome VARCHAR(255),
                          raca VARCHAR(255),
                          genero VARCHAR(50),
                          idade INT,
                          tutor_id INT,
                          FOREIGN KEY (tutor_id) REFERENCES Tutor(id)
);
