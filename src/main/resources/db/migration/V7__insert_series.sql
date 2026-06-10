INSERT INTO series (titulo, annoEstreno, genero, numCaps) VALUES
                                                              ('Breaking Code', '2020', 'Drama', 24),
                                                              ('Space Hunters', '2022', 'Ciencia Ficción', 18),
                                                              ('The Last Detective', '2019', 'Crimen', 30);

INSERT INTO series_director (serie_id, director_id) VALUES
                                                        (1, 1),
                                                        (2, 2),
                                                        (3, 1);

INSERT INTO series_actor (serie_id, actor_id) VALUES
                                                  (1, 1),
                                                  (2, 2),
                                                  (3, 3);