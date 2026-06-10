DROP TABLE IF EXISTS series_actor;
DROP TABLE IF EXISTS series_director;
DROP TABLE IF EXISTS series_genero;
DROP TABLE IF EXISTS series_temporada;
DROP TABLE IF EXISTS series;

CREATE TABLE IF NOT EXISTS series (
                                      id INTEGER PRIMARY KEY AUTOINCREMENT,
                                      titulo TEXT NOT NULL,
                                      annoEstreno TEXT
);

CREATE TABLE IF NOT EXISTS series_genero (
                                             serie_id INTEGER NOT NULL,
                                             genero TEXT NOT NULL,

                                             ```
                                             PRIMARY KEY (serie_id, genero),

                                             FOREIGN KEY (serie_id)
                                                 REFERENCES series(id)
                                                 ON DELETE CASCADE
                                             ```

);

CREATE TABLE IF NOT EXISTS series_temporada (
                                                serie_id INTEGER NOT NULL,
                                                numero_temporada INTEGER NOT NULL,
                                                num_episodios INTEGER NOT NULL,

                                                ```
                                                PRIMARY KEY (serie_id, numero_temporada),

                                                FOREIGN KEY (serie_id)
                                                    REFERENCES series(id)
                                                    ON DELETE CASCADE
                                                ```

);

CREATE TABLE IF NOT EXISTS series_director (
                                               serie_id INTEGER NOT NULL,
                                               director_id INTEGER NOT NULL,

                                               ```
                                               PRIMARY KEY (serie_id, director_id),

                                               FOREIGN KEY (serie_id)
                                                   REFERENCES series(id)
                                                   ON DELETE CASCADE,

                                               FOREIGN KEY (director_id)
                                                   REFERENCES directores(id)
                                                   ON DELETE CASCADE
                                               ```

);

CREATE TABLE IF NOT EXISTS series_actor (
                                            actor_id INTEGER NOT NULL,
                                            serie_id INTEGER NOT NULL,

                                            ```
                                            PRIMARY KEY (actor_id, serie_id),

                                            FOREIGN KEY (serie_id)
                                                REFERENCES series(id)
                                                ON DELETE CASCADE,

                                            FOREIGN KEY (actor_id)
                                                REFERENCES actores(id)
                                                ON DELETE CASCADE
                                            ```

);
