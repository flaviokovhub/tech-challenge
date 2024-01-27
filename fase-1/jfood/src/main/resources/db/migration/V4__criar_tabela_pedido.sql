CREATE TABLE pedido (
 id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 cpf VARCHAR(18),
 tipo_pagamento VARCHAR(20) NOT NULL,
 total DECIMAL NOT NULL,
 status VARCHAR(20) NOT NULL,
 data_pedido timestamp NOT NULL
);

CREATE TABLE itenspedido (
                         id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                         quantidade numeric NOT NULL,
                         categoria VARCHAR(50) NOT NULL,
                         nome VARCHAR(100) NOT NULL,
                         descricao VARCHAR(255) NOT NULL,
                         valor DECIMAL NOT NULL,
                         pedido_id int NOT NULL
);

ALTER TABLE itenspedido ADD CONSTRAINT FK_ITENS_PEDIDO
    FOREIGN KEY (pedido_id) REFERENCES pedido (id);