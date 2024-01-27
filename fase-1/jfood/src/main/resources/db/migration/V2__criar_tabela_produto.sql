CREATE TABLE produtos (
    id VARCHAR(40) NOT NULL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    imagem_url VARCHAR(255) NOT NULL,
    preco DECIMAL NOT NULL
);