CREATE TABLE produto (

    ID INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(100) DEFAULT NULL,
    DESCRICAO VARCHAR(255) DEFAULT NULL,
    PRECO DOUBLE DEFAULT NULL,
    FABRICANTE_ID INT,
    PRIMARY KEY (ID),
    FOREIGN KEY (FABRICANTE_ID) REFERENCES fabricantes(ID)
);