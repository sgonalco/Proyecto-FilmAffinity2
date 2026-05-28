CREATE TABLE IF NOT EXISTS directores (
                                          id INTEGER PRIMARY KEY AUTOINCREMENT ,
                                          nombre TEXT NOT NULL,
                                          fecha_nacimiento TEXT
);

CREATE TABLE IF NOT EXISTS pelicula_director (
                                                 pelicula_id INTEGER NOT NULL,
                                                 director_id INTEGER NOT NULL,

                                                 PRIMARY KEY (pelicula_id, director_id),

                                                 FOREIGN KEY (pelicula_id)
                                                     REFERENCES peliculas(id)
                                                     ON DELETE CASCADE,

                                                 FOREIGN KEY (director_id)
                                                     REFERENCES directores(id)
                                                     ON DELETE CASCADE
);