CREATE TABLE IF NOT EXISTS series (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT NOT NULL,
    annoEstreno TEXT,
    genero TEXT NOT NULL,
    numCaps INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS series_director (
    serie_id INTEGER NOT NULL,
    director_id INTEGER NOT NULL,
    PRIMARY KEY (serie_id, director_id),

    FOREIGN KEY (serie_id)
        REFERENCES series(id)
        ON DELETE CASCADE,

    FOREIGN KEY (director_id)
        REFERENCES directores(id)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS series_actor (
    actor_id INTEGER NOT NULL,
    serie_id INTEGER NOT NULL,
    PRIMARY KEY (actor_id, serie_id),

    FOREIGN KEY (serie_id)
        REFERENCES series(id)
        ON DELETE CASCADE,

    FOREIGN KEY (actor_id)
        REFERENCES actores(id)
        ON DELETE CASCADE
);