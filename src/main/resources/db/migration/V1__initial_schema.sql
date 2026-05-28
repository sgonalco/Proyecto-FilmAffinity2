-- ===============================
-- ACTORES
-- ===============================
CREATE TABLE IF NOT EXISTS actores (
                                       id INTEGER PRIMARY KEY AUTOINCREMENT,
                                       nombre TEXT NOT NULL,
                                       fecha_nacimiento TEXT,
                                       pais_nacimiento TEXT
);

-- ===============================
-- PELICULAS
-- ===============================
CREATE TABLE IF NOT EXISTS peliculas (
                                         id INTEGER PRIMARY KEY AUTOINCREMENT,
                                         titulo TEXT NOT NULL,
                                         anio INTEGER NOT NULL,
                                         duracion INTEGER,
                                         pais TEXT,
                                         direccion TEXT,
                                         genero TEXT,
                                         sinopsis TEXT,
                                         portada TEXT
);

-- ===============================
-- REPARTO (pelicula - actores)
-- ===============================
CREATE TABLE IF NOT EXISTS reparto (
                                       pelicula_id INTEGER NOT NULL,
                                       actor_id INTEGER NOT NULL,
                                       PRIMARY KEY (pelicula_id, actor_id),
                                       FOREIGN KEY (pelicula_id) REFERENCES peliculas(id) ON DELETE CASCADE,
                                       FOREIGN KEY (actor_id) REFERENCES actores(id) ON DELETE CASCADE
);
