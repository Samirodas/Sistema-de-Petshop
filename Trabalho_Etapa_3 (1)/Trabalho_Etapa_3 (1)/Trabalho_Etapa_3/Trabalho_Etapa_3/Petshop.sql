CREATE DATABASE IF NOT EXISTS petshop;

USE petshop;

CREATE TABLE IF NOT EXISTS Animal (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raca VARCHAR(50),
    idade INT,
    sexo VARCHAR(10),
    peso DOUBLE,
    foto BLOB
);

CREATE TABLE IF NOT EXISTS Proprietario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Servico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DOUBLE
);

CREATE TABLE IF NOT EXISTS HistoricoServico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    servico_id INT,
    valor DOUBLE,
    observacoes TEXT,
    data DATE,
    FOREIGN KEY (animal_id) REFERENCES Animal(id),
    FOREIGN KEY (servico_id) REFERENCES Servico(id)
);
