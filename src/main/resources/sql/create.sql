CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    matricula VARCHAR(20) NOT NULL
);

CREATE TABLE Professor (
    id int PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE disciplina (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    curso VARCHAR(100) NOT NULL,
    turma VARCHAR(25) NOT NULL,
    local VARCHAR(25) NOT NULL,
    professor_id int,
    FOREIGN KEY (professor_id) REFERENCES Professor (id)
);

CREATE TABLE aluno_disciplina (
    aluno_id int NOT NULL,
    disciplina_id int NOT NULL,
    PRIMARY KEY (aluno_id, disciplina_id),
    FOREIGN KEY (aluno_id) REFERENCES Aluno (id),
    FOREIGN KEY (disciplina_id) REFERENCES Disciplina (id)
);