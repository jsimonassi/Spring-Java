DROP TABLE IF EXISTS locacao_veiculos.clients;
DROP TABLE IF EXISTS locacao_veiculos.cars;

CREATE TABLE locacao_veiculos.clients (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(127) NOT NULL,
  cpf VARCHAR(30) NOT NULL,
  registered_at DATETIME DEFAULT now(),
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8mb4;

CREATE TABLE locacao_veiculos.cars (
  id INT NOT NULL AUTO_INCREMENT,
  identification VARCHAR(127) NOT NULL,
  model VARCHAR(127),
  brand VARCHAR(127),
  registered_at DATETIME DEFAULT now(),
  PRIMARY KEY (id)
)
ENGINE = INNODB
CHARACTER SET utf8mb4;

INSERT INTO clients(NAME, CPF)
VALUES('João Victor Simonassi', '14902272709');

INSERT INTO clients(NAME, CPF)
VALUES('Fulano da Silva', '12345678911');

INSERT INTO cars(identification, model, brand)
VALUES ('LXR5540', 'Civic', 'Honda');

INSERT INTO cars(identification, model, brand)
VALUES ('LPT8827', 'Gol', 'VW');

select * from clients;
select * from cars;

