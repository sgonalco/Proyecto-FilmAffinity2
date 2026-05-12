USE filmaffinity2db;

-- ===============================
-- ACTORES
-- ===============================
CREATE TABLE actores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    fecha_nacimiento DATE,
    pais_nacimiento VARCHAR(80)
);

-- ===============================
-- PELICULAS
-- ===============================
CREATE TABLE peliculas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    anio YEAR NOT NULL,
    duracion INT,
    pais VARCHAR(80),
    direccion VARCHAR(150),       -- Just a text field, not a separate table
    genero VARCHAR(80),           -- Same: no need for a genre table
    sinopsis TEXT,
    portada VARCHAR(255)
);

-- ===============================
-- REPARTO (pelicula - actores)
-- ===============================
CREATE TABLE reparto (
    pelicula_id INT NOT NULL,
    actor_id INT NOT NULL,
    PRIMARY KEY (pelicula_id, actor_id),
    FOREIGN KEY (pelicula_id) REFERENCES peliculas(id) ON DELETE CASCADE,
    FOREIGN KEY (actor_id) REFERENCES actores(id) ON DELETE CASCADE
);
