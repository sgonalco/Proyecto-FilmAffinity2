USE filmaffinity2db;

INSERT INTO actores (nombre, fecha_nacimiento, pais_nacimiento) VALUES
('Leonardo DiCaprio', '1974-11-11', 'Estados Unidos'),
('Kate Winslet', '1975-10-05', 'Reino Unido'),
('Christian Bale', '1974-01-30', 'Reino Unido'),
('Heath Ledger', '1979-04-04', 'Australia'),
('Keanu Reeves', '1964-09-02', 'Canadá'),
('Carrie-Anne Moss', '1967-08-21', 'Canadá'),
('Matthew McConaughey', '1969-11-04', 'Estados Unidos'),
('Anne Hathaway', '1982-11-12', 'Estados Unidos');

INSERT INTO peliculas (
    titulo, anio, duracion, pais, direccion, genero, sinopsis, portada
) VALUES
(
    'Titanic',
    1997,
    195,
    'Estados Unidos',
    'James Cameron',
    'Drama, Romance',
    'Una historia de amor entre dos jóvenes de distintas clases sociales a bordo del Titanic.',
    'titanic.jpg'
),
(
    'The Dark Knight',
    2008,
    152,
    'Estados Unidos',
    'Christopher Nolan',
    'Acción, Crimen',
    'Batman se enfrenta al Joker, un criminal que busca sembrar el caos en Gotham.',
    'dark_knight.jpg'
),
(
    'The Matrix',
    1999,
    136,
    'Estados Unidos',
    'Lana Wachowski, Lilly Wachowski',
    'Ciencia ficción, Acción',
    'Un hacker descubre la verdadera naturaleza de la realidad.',
    'matrix.jpg'
),
(
    'Interstellar',
    2014,
    169,
    'Estados Unidos',
    'Christopher Nolan',
    'Ciencia ficción, Drama',
    'Un grupo de exploradores viaja a través de un agujero de gusano en busca de un nuevo hogar para la humanidad.',
    'interstellar.jpg'
);

-- Titanic
INSERT INTO reparto (pelicula_id, actor_id) VALUES
(1, 1), -- Leonardo DiCaprio
(1, 2); -- Kate Winslet

-- The Dark Knight
INSERT INTO reparto (pelicula_id, actor_id) VALUES
(2, 3), -- Christian Bale
(2, 4); -- Heath Ledger

-- The Matrix
INSERT INTO reparto (pelicula_id, actor_id) VALUES
(3, 5), -- Keanu Reeves
(3, 6); -- Carrie-Anne Moss

-- Interstellar
INSERT INTO reparto (pelicula_id, actor_id) VALUES
(4, 7), -- Matthew McConaughey
(4, 8); -- Anne Hathaway