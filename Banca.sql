CREATE TABLE cc (
 iban varchar(27) PRIMARY KEY NOT NULL,
 nome varchar(20) NOT NULL,
 saldo float(12)DEFAULT 0,
 idi number(3),
FOREIGN KEY(idi) REFERENCES intestatario(idi))