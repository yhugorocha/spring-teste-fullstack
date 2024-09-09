CREATE TABLE ficha_veiculo (
     id UUID PRIMARY KEY,
     veiculo VARCHAR(255) NOT NULL,
     marca VARCHAR(255) NOT NULL,
     ano INT NOT NULL,
     descricao TEXT NOT NULL,
     vendido BOOLEAN NOT NULL,
     created TIMESTAMP NOT NULL,
     update TIMESTAMP NULL,
     chassi VARCHAR(255) UNIQUE NOT NULL,
     preco DECIMAL(15, 2) NOT NULL
);
