DROP DATABASE IF EXISTS Cinema;
CREATE DATABASE Cinema;

use Cinema;

CREATE TABLE Filme (
     idFilme INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
     nomeFilme VARCHAR(50) NOT NULL,
     duracao VARCHAR (6) NOT NULL,
     classificacao VARCHAR(2) NOT NULL,
     sinopse VARCHAR (1000) NOT NULL,
     genero VARCHAR (20) NOT NULL
);

CREATE TABLE Sala (
     numeroSala INT PRIMARY KEY NOT NULL,
     tipoSala INT(1) NOT NULL,
     capacidade INT NOT NULL
);

CREATE TABLE Poltrona (
     idPoltrona VARCHAR (3) NOT NULL,
     acessibilidade BOOLEAN NOT NULL,
     disponibilidade BOOLEAN NOT NULL,
     numeroSala INT NOT NULL,
     PRIMARY KEY (idPoltrona, numeroSala),
     FOREIGN KEY (numeroSala) REFERENCES Sala(numeroSala) 
);

CREATE TABLE Sala_Poltrona (
    numeroSala INT NOT NULL,
    idPoltrona VARCHAR(3) NOT NULL,
    PRIMARY KEY (numeroSala, idPoltrona),
    FOREIGN KEY (numeroSala) REFERENCES Sala(numeroSala),
    FOREIGN KEY (idPoltrona) REFERENCES Poltrona(idPoltrona)
);

CREATE TABLE Sessao (
     idSessao INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     dataInicio VARCHAR (10) NOT NULL,
     dataFim VARCHAR (10) NOT NULL,
     horario VARCHAR (4) NOT NULL,
     numeroSala INT NOT NULL,
     idFilme INT NOT NULL,
     FOREIGN KEY (numeroSala) REFERENCES Sala(numeroSala),
     FOREIGN KEY (idFilme) REFERENCES Filme(idFilme)
);

CREATE TABLE Administrador(
     idAdmin INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
     login VARCHAR(20) NOT NULL,
     senha VARCHAR(20) NOT NULL
);

INSERT INTO Filme values 
(NULL, 'HARRY POTTER E O PRISIONEIRO DE AZKABAN','2h22m','L', 'O 3º ano de ensino na Escola de Magia e Bruxaria de Hogwarts se aproxima. Porém um grande perigo ronda a escola: o assassino Sirius Black (Gary Oldman) fugiu da prisão de Azkaban, considerada até então como à prova de fugas. Para proteger a escola são enviados os Dementadores, estranhos seres que sugam a energia vital de quem se aproxima deles, que tanto podem defender a escola como piorar ainda mais a situação.', 'Aventura/Fantasia'), 
(NULL, 'FURIOSA: UMA SAGA MAD MAX','2h28m','12', 'Furiosa: Uma Saga Mad Max é um filme de ficção científica pós-apocalíptico dirigido por George Miller e estrelado por Anya Taylor-Joy, Chris Hemsworth e Tom Burke. A trama revela a história de origem da guerreira renegada Furiosa, anteriormente interpretada por Charlize Theron, narrando sua jornada até se unir a Max em Mad Max: Estrada da Fúria (2015). O enredo segue uma jovem Furiosa (Anya Taylor-Joy), sequestrada de seu lar, o Lugar Verde de Muitas Mães, por uma grande horda de motoqueiros liderada pelo senhor da guerra Dementus (Chris Hemsworth). Cruzando Wasteland, eles alcançam a Cidadela, dominada pelo Immortan Joe (Lachy Hulme). Enquanto os dois tiranos disputam o domínio, Furiosa se vê envolvida em uma batalha incessante para retornar ao seu lar. O filme oferece uma visão mais profunda do universo de Mad Max, explorando os motivos e desafios enfrentados por um dos personagens mais marcantes da franquia.','Ação/Ficção'), 
(NULL, 'GARFIELD: O FILME','1h41m','L', 'Depois de um reencontro inesperado com seu pai há muito perdido, o gato de rua Vic, Garfield é forçado a deixar para trás sua vida muito confortável com Harald. Junto com Vic e Odie, ele planeja um assalto maluco.','Família/Comédia');

INSERT INTO Sala values (1, 1, 114), 
                        (2, 1, 114), 
                        (3, 1, 114);

INSERT INTO Poltrona values ('A1', false, true, 1), ('A2', false, true, 1), ('A3', false, true, 1), ('A4', false, true, 1),
                            ('A5', false, true, 1), ('A6', false, true, 1), ('A7', false, true, 1), ('A8', false, true, 1),
                            ('A9', false, true, 1), ('A10', false, true, 1), ('A11', false, true, 1), ('A12', false, true, 1),
                            ('A13', false, true, 1), ('A14', false, true, 1),

                            ('B1', false, true, 1), ('B2', false, true, 1), ('B3', false, true, 1), ('B4', false, true, 1),
                            ('B5', false, true, 1), ('B6', false, true, 1), ('B7', false, true, 1), ('B8', false, true, 1),
                            ('B9', false, true, 1), ('B10', false, true, 1), ('B11', false, true, 1), ('B12', false, true, 1),
                            ('B13', false, true, 1), ('B14', false, true, 1),

                            ('C1', false, true, 1), ('C2', false, true, 1), ('C3', false, true, 1), ('C4', false, true, 1),
                            ('C5', false, true, 1), ('C6', false, true, 1), ('C7', false, true, 1), ('C8', false, true, 1),
                            ('C9', false, true, 1), ('C10', false, true, 1), ('C11', false, true, 1), ('C12', false, true, 1),
                            ('C13', false, true, 1), ('C14', false, true, 1),

                            ('D1', false, true, 1), ('D2', false, true, 1), ('D3', false, true, 1), ('D4', false, true, 1),
                            ('D5', false, true, 1), ('D6', false, true, 1), ('D7', false, true, 1), ('D8', false, true, 1),

                            ('E1', false, true, 1), ('E2', false, true, 1), ('E3', false, true, 1), ('E4', false, true, 1),
                            ('E5', false, true, 1), ('E6', false, true, 1), ('E7', false, true, 1), ('E8', false, true, 1),

                            ('F1', false, true, 1), ('F2', false, true, 1), ('F3', false, true, 1), ('F4', false, true, 1),
                            ('F5', false, true, 1), ('F6', false, true, 1), ('F7', false, true, 1), ('F8', false, true, 1),

                            ('G1', false, true, 1), ('G2', false, true, 1), ('G3', false, true, 1), ('G4', false, true, 1),
                            ('G5', false, true, 1), ('G6', false, true, 1), ('G7', false, true, 1), ('G8', false, true, 1),

                            ('H1', false, true, 1), ('H2', false, true, 1), ('H3', false, true, 1), ('H4', false, true, 1),
                            ('H5', false, true, 1), ('H6', false, true, 1), ('H7', false, true, 1), ('H8', false, true, 1),

                            ('I1', false, true, 1), ('I2', false, true, 1), ('I3', false, true, 1), ('I4', false, true, 1),
                            ('I5', false, true, 1), ('I6', false, true, 1), ('I7', false, true, 1), ('I8', false, true, 1),

                            ('J1', false, true, 1), ('J2', false, true, 1), ('J3', false, true, 1), ('J4', false, true, 1),
                            ('J5', false, true, 1), ('J6', false, true, 1), ('J7', false, true, 1), ('J8', false, true, 1),

                            ('K1', false, true, 1), ('K2', false, true, 1), ('K3', false, true, 1), ('K4', false, true, 1),
                            ('K5', false, true, 1), ('K6', false, true, 1), ('K7', false, true, 1), ('K8', false, true, 1),
                            ('K9', false, true, 1), ('K10', false, true, 1), ('K11', false, true, 1), ('K12', false, true, 1),
                            ('K13', false, true, 1), ('K14', false, true, 1), ('K15', false, true, 1), ('K16', false, true, 1),

                            ('A1', false, true, 2), ('A2', false, true, 2), ('A3', false, true, 2), ('A4', false, true, 2),
                            ('A5', false, true, 2), ('A6', false, true, 2), ('A7', false, true, 2), ('A8', false, true, 2),
                            ('A9', false, true, 2), ('A10', false, true, 2), ('A11', false, true, 2), ('A12', false, true, 2),
                            ('A13', false, true, 2), ('A14', false, true, 2),

                            ('B1', false, true, 2), ('B2', false, true, 2), ('B3', false, true, 2), ('B4', false, true, 2),
                            ('B5', false, true, 2), ('B6', false, true, 2), ('B7', false, true, 2), ('B8', false, true, 2),
                            ('B9', false, true, 2), ('B10', false, true, 2), ('B11', false, true, 2), ('B12', false, true, 2),
                            ('B13', false, true, 2), ('B14', false, true, 2),

                            ('C1', false, true, 2), ('C2', false, true, 2), ('C3', false, true, 2), ('C4', false, true, 2),
                            ('C5', false, true, 2), ('C6', false, true, 2), ('C7', false, true, 2), ('C8', false, true, 2),
                            ('C9', false, true, 2), ('C10', false, true, 2), ('C11', false, true, 2), ('C12', false, true, 2),
                            ('C13', false, true, 2), ('C14', false, true, 2),

                            ('D1', false, true, 2), ('D2', false, true, 2), ('D3', false, true, 2), ('D4', false, true, 2),
                            ('D5', false, true, 2), ('D6', false, true, 2), ('D7', false, true, 2), ('D8', false, true, 2),

                            ('E1', false, true, 2), ('E2', false, true, 2), ('E3', false, true, 2), ('E4', false, true, 2),
                            ('E5', false, true, 2), ('E6', false, true, 2), ('E7', false, true, 2), ('E8', false, true, 2),

                            ('F1', false, true, 2), ('F2', false, true, 2), ('F3', false, true, 2), ('F4', false, true, 2),
                            ('F5', false, true, 2), ('F6', false, true, 2), ('F7', false, true, 2), ('F8', false, true, 2),

                            ('G1', false, true, 2), ('G2', false, true, 2), ('G3', false, true, 2), ('G4', false, true, 2),
                            ('G5', false, true, 2), ('G6', false, true, 2), ('G7', false, true, 2), ('G8', false, true, 2),

                            ('H1', false, true, 2), ('H2', false, true, 2), ('H3', false, true, 2), ('H4', false, true, 2),
                            ('H5', false, true, 2), ('H6', false, true, 2), ('H7', false, true, 2), ('H8', false, true, 2),

                            ('I1', false, true, 2), ('I2', false, true, 2), ('I3', false, true, 2), ('I4', false, true, 2),
                            ('I5', false, true, 2), ('I6', false, true, 2), ('I7', false, true, 2), ('I8', false, true, 2),

                            ('J1', false, true, 2), ('J2', false, true, 2), ('J3', false, true, 2), ('J4', false, true, 2),
                            ('J5', false, true, 2), ('J6', false, true, 2), ('J7', false, true, 2), ('J8', false, true, 2),

                            ('K1', false, true, 2), ('K2', false, true, 2), ('K3', false, true, 2), ('K4', false, true, 2),
                            ('K5', false, true, 2), ('K6', false, true, 2), ('K7', false, true, 2), ('K8', false, true, 2),
                            ('K9', false, true, 2), ('K10', false, true, 2), ('K11', false, true, 2), ('K12', false, true, 2),
                            ('K13', false, true, 2), ('K14', false, true, 2), ('K15', false, true, 2), ('K16', false, true, 2),

                            ('A1', false, true, 3), ('A2', false, true, 3), ('A3', false, true, 3), ('A4', false, true, 3),
                            ('A5', false, true, 3), ('A6', false, true, 3), ('A7', false, true, 3), ('A8', false, true, 3),
                            ('A9', false, true, 3), ('A10', false, true, 3), ('A11', false, true, 3), ('A12', false, true, 3),
                            ('A13', false, true, 3), ('A14', false, true, 3),

                            ('B1', false, true, 3), ('B2', false, true, 3), ('B3', false, true, 3), ('B4', false, true, 3),
                            ('B5', false, true, 3), ('B6', false, true, 3), ('B7', false, true, 3), ('B8', false, true, 3),
                            ('B9', false, true, 3), ('B10', false, true, 3), ('B11', false, true, 3), ('B12', false, true, 3),
                            ('B13', false, true, 3), ('B14', false, true, 3),

                            ('C1', false, true, 3), ('C2', false, true, 3), ('C3', false, true, 3), ('C4', false, true, 3),
                            ('C5', false, true, 3), ('C6', false, true, 3), ('C7', false, true, 3), ('C8', false, true, 3),
                            ('C9', false, true, 3), ('C10', false, true, 3), ('C11', false, true, 3), ('C12', false, true, 3),
                            ('C13', false, true, 3), ('C14', false, true, 3),

                            ('D1', false, true, 3), ('D2', false, true, 3), ('D3', false, true, 3), ('D4', false, true, 3),
                            ('D5', false, true, 3), ('D6', false, true, 3), ('D7', false, true, 3), ('D8', false, true, 3),

                            ('E1', false, true, 3), ('E2', false, true, 3), ('E3', false, true, 3), ('E4', false, true, 3),
                            ('E5', false, true, 3), ('E6', false, true, 3), ('E7', false, true, 3), ('E8', false, true, 3),

                            ('F1', false, true, 3), ('F2', false, true, 3), ('F3', false, true, 3), ('F4', false, true, 3),
                            ('F5', false, true, 3), ('F6', false, true, 3), ('F7', false, true, 3), ('F8', false, true, 3),

                            ('G1', false, true, 3), ('G2', false, true, 3), ('G3', false, true, 3), ('G4', false, true, 3),
                            ('G5', false, true, 3), ('G6', false, true, 3), ('G7', false, true, 3), ('G8', false, true, 3),

                            ('H1', false, true, 3), ('H2', false, true, 3), ('H3', false, true, 3), ('H4', false, true, 3),
                            ('H5', false, true, 3), ('H6', false, true, 3), ('H7', false, true, 3), ('H8', false, true, 3),

                            ('I1', false, true, 3), ('I2', false, true, 3), ('I3', false, true, 3), ('I4', false, true, 3),
                            ('I5', false, true, 3), ('I6', false, true, 3), ('I7', false, true, 3), ('I8', false, true, 3),

                            ('J1', false, true, 3), ('J2', false, true, 3), ('J3', false, true, 3), ('J4', false, true, 3),
                            ('J5', false, true, 3), ('J6', false, true, 3), ('J7', false, true, 3), ('J8', false, true, 3),

                            ('K1', false, true, 3), ('K2', false, true, 3), ('K3', false, true, 3), ('K4', false, true, 3),
                            ('K5', false, true, 3), ('K6', false, true, 3), ('K7', false, true, 3), ('K8', false, true, 3),
                            ('K9', false, true, 3), ('K10', false, true, 3), ('K11', false, true, 3), ('K12', false, true, 3),
                            ('K13', false, true, 3), ('K14', false, true, 3), ('K15', false, true, 3), ('K16', false, true, 3);

INSERT INTO Sala_Poltrona (numeroSala, idPoltrona) VALUES
(1, 'A1'), (1, 'A2'), (1, 'A3'), (1, 'A4'), (1, 'A5'), (1, 'A6'), (1, 'A7'), (1, 'A8'), (1, 'A9'), (1, 'A10'), (1, 'A11'), (1, 'A12'), (1, 'A13'), (1, 'A14'),
(1, 'B1'), (1, 'B2'), (1, 'B3'), (1, 'B4'), (1, 'B5'), (1, 'B6'), (1, 'B7'), (1, 'B8'), (1, 'B9'), (1, 'B10'), (1, 'B11'), (1, 'B12'), (1, 'B13'), (1, 'B14'),
(1, 'C1'), (1, 'C2'), (1, 'C3'), (1, 'C4'), (1, 'C5'), (1, 'C6'), (1, 'C7'), (1, 'C8'), (1, 'C9'), (1, 'C10'), (1, 'C11'), (1, 'C12'), (1, 'C13'), (1, 'C14'),
(1, 'D1'), (1, 'D2'), (1, 'D3'), (1, 'D4'), (1, 'D5'), (1, 'D6'), (1, 'D7'), (1, 'D8'), 
(1, 'E1'), (1, 'E2'), (1, 'E3'), (1, 'E4'), (1, 'E5'), (1, 'E6'), (1, 'E7'), (1, 'E8'), 
(1, 'F1'), (1, 'F2'), (1, 'F3'), (1, 'F4'), (1, 'F5'), (1, 'F6'), (1, 'F7'), (1, 'F8'), 
(1, 'G1'), (1, 'G2'), (1, 'G3'), (1, 'G4'), (1, 'G5'), (1, 'G6'), (1, 'G7'), (1, 'G8'), 
(1, 'H1'), (1, 'H2'), (1, 'H3'), (1, 'H4'), (1, 'H5'), (1, 'H6'), (1, 'H7'), (1, 'H8'), 
(1, 'I1'), (1, 'I2'), (1, 'I3'), (1, 'I4'), (1, 'I5'), (1, 'I6'), (1, 'I7'), (1, 'I8'), 
(1, 'J1'), (1, 'J2'), (1, 'J3'), (1, 'J4'), (1, 'J5'), (1, 'J6'), (1, 'J7'), (1, 'J8'), 
(1, 'K1'), (1, 'K2'), (1, 'K3'), (1, 'K4'), (1, 'K5'), (1, 'K6'), (1, 'K7'), (1, 'K8'), (1, 'K9'), (1, 'K10'), (1, 'K11'), (1, 'K12'), (1, 'K13'), (1, 'K14'), (1, 'K15'), (1, 'K16'),
(2, 'A1'), (2, 'A2'), (2, 'A3'), (2, 'A4'), (2, 'A5'), (2, 'A6'), (2, 'A7'), (2, 'A8'), (2, 'A9'), (2, 'A10'), (2, 'A11'), (2, 'A12'), (2, 'A13'), (2, 'A14'),
(2, 'B1'), (2, 'B2'), (2, 'B3'), (2, 'B4'), (2, 'B5'), (2, 'B6'), (2, 'B7'), (2, 'B8'), (2, 'B9'), (2, 'B10'), (2, 'B11'), (2, 'B12'), (2, 'B13'), (2, 'B14'),
(2, 'C1'), (2, 'C2'), (2, 'C3'), (2, 'C4'), (2, 'C5'), (2, 'C6'), (2, 'C7'), (2, 'C8'), (2, 'C9'), (2, 'C10'), (2, 'C11'), (2, 'C12'), (2, 'C13'), (2, 'C14'),
(2, 'D1'), (2, 'D2'), (2, 'D3'), (2, 'D4'), (2, 'D5'), (2, 'D6'), (2, 'D7'), (2, 'D8'), 
(2, 'E1'), (2, 'E2'), (2, 'E3'), (2, 'E4'), (2, 'E5'), (2, 'E6'), (2, 'E7'), (2, 'E8'), 
(2, 'F1'), (2, 'F2'), (2, 'F3'), (2, 'F4'), (2, 'F5'), (2, 'F6'), (2, 'F7'), (2, 'F8'), 
(2, 'G1'), (2, 'G2'), (2, 'G3'), (2, 'G4'), (2, 'G5'), (2, 'G6'), (2, 'G7'), (2, 'G8'), 
(2, 'H1'), (2, 'H2'), (2, 'H3'), (2, 'H4'), (2, 'H5'), (2, 'H6'), (2, 'H7'), (2, 'H8'), 
(2, 'I1'), (2, 'I2'), (2, 'I3'), (2, 'I4'), (2, 'I5'), (2, 'I6'), (2, 'I7'), (2, 'I8'), 
(2, 'J1'), (2, 'J2'), (2, 'J3'), (2, 'J4'), (2, 'J5'), (2, 'J6'), (2, 'J7'), (2, 'J8'), 
(2, 'K1'), (2, 'K2'), (2, 'K3'), (2, 'K4'), (2, 'K5'), (2, 'K6'), (2, 'K7'), (2, 'K8'), (2, 'K9'), (2, 'K10'), (2, 'K11'), (2, 'K12'), (2, 'K13'), (2, 'K14'), (2, 'K15'), (2, 'K16'),
(3, 'A1'), (3, 'A2'), (3, 'A3'), (3, 'A4'), (3, 'A5'), (3, 'A6'), (3, 'A7'), (3, 'A8'), (3, 'A9'), (3, 'A10'), (3, 'A11'), (3, 'A12'), (3, 'A13'), (3, 'A14'),
(3, 'B1'), (3, 'B2'), (3, 'B3'), (3, 'B4'), (3, 'B5'), (3, 'B6'), (3, 'B7'), (3, 'B8'), (3, 'B9'), (3, 'B10'), (3, 'B11'), (3, 'B12'), (3, 'B13'), (3, 'B14'),
(3, 'C1'), (3, 'C2'), (3, 'C3'), (3, 'C4'), (3, 'C5'), (3, 'C6'), (3, 'C7'), (3, 'C8'), (3, 'C9'), (3, 'C10'), (3, 'C11'), (3, 'C12'), (3, 'C13'), (3, 'C14'),
(3, 'D1'), (3, 'D2'), (3, 'D3'), (3, 'D4'), (3, 'D5'), (3, 'D6'), (3, 'D7'), (3, 'D8'), 
(3, 'E1'), (3, 'E2'), (3, 'E3'), (3, 'E4'), (3, 'E5'), (3, 'E6'), (3, 'E7'), (3, 'E8'), 
(3, 'F1'), (3, 'F2'), (3, 'F3'), (3, 'F4'), (3, 'F5'), (3, 'F6'), (3, 'F7'), (3, 'F8'), 
(3, 'G1'), (3, 'G2'), (3, 'G3'), (3, 'G4'), (3, 'G5'), (3, 'G6'), (3, 'G7'), (3, 'G8'), 
(3, 'H1'), (3, 'H2'), (3, 'H3'), (3, 'H4'), (3, 'H5'), (3, 'H6'), (3, 'H7'), (3, 'H8'), 
(3, 'I1'), (3, 'I2'), (3, 'I3'), (3, 'I4'), (3, 'I5'), (3, 'I6'), (3, 'I7'), (3, 'I8'), 
(3, 'J1'), (3, 'J2'), (3, 'J3'), (3, 'J4'), (3, 'J5'), (3, 'J6'), (3, 'J7'), (3, 'J8'), 
(3, 'K1'), (3, 'K2'), (3, 'K3'), (3, 'K4'), (3, 'K5'), (3, 'K6'), (3, 'K7'), (3, 'K8'), (3, 'K9'), (3, 'K10'), (3, 'K11'), (3, 'K12'), (3, 'K13'), (3, 'K14'), (3, 'K15'), (3, 'K16');

INSERT INTO Sessao (dataInicio, dataFim, horario, numeroSala, idFilme) VALUES 
                            ('2024-06-04', '2024-07-04', '16:00:00', 1, 3),
                            ('2024-06-04', '2024-07-04', '19:00:00', 1, 1),
                            ('2024-06-04', '2024-07-04', '22:00:00', 1, 2),
                            ('2024-06-04', '2024-07-04', '16:00:00', 2, 1),
                            ('2024-06-04', '2024-07-04', '19:00:00', 2, 2),
                            ('2024-06-04', '2024-07-04', '22:00:00', 2, 3),
                            ('2024-06-04', '2024-07-04', '16:00:00', 3, 2),
                            ('2024-06-04', '2024-07-04', '19:00:00', 3, 3),
                            ('2024-06-04', '2024-07-04', '22:00:00', 3, 1);


INSERT INTO Administrador values (NULL, 'admin', 'admin');
