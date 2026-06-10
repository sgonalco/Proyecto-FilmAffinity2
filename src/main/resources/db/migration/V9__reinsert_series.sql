INSERT INTO series (titulo, annoEstreno) VALUES
                                             ('Breaking Code', '2020'),
                                             ('Space Hunters', '2022'),
                                             ('The Last Detective', '2019');

-- Géneros

INSERT INTO series_genero (serie_id, genero) VALUES
                                                 (1, 'Drama'),
                                                 (1, 'Tecnología'),

                                                 (2, 'Ciencia Ficción'),
                                                 (2, 'Aventura'),

                                                 (3, 'Crimen'),
                                                 (3, 'Misterio');

-- Temporadas
-- numero_temporada, num_episodios

INSERT INTO series_temporada (serie_id, numero_temporada, num_episodios) VALUES
                                                                             (1, 1, 10),
                                                                             (1, 2, 8),

                                                                             (2, 1, 12),
                                                                             (2, 2, 10),
                                                                             (2, 3, 8),

                                                                             (3, 1, 6),
                                                                             (3, 2, 6);

-- Directores

INSERT INTO series_director (serie_id, director_id) VALUES
                                                        (1, 1),
                                                        (2, 2),
                                                        (3, 1);

-- Actores

INSERT INTO series_actor (serie_id, actor_id) VALUES
                                                  (1, 1),
                                                  (1, 2),

                                                  (2, 5),
                                                  (2, 6),

                                                  (3, 3),
                                                  (3, 4);
