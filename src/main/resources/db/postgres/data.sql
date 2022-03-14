INSERT INTO employees VALUES (1, 'John Galt', 'John Galt') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (2, 'Ragnar Danneskjold', 'John Galt') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (3, 'Dagny Taggart', 'John Galt') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (4, 'Francisco d''Anconia', 'John Galt') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (5, 'Hank Reardon', 'Ragnar Danneskjold') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (6, 'Eddie Willers', 'Ragnar Danneskjold') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (7, 'Ken Dannager', 'Ragnar Danneskjold') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (8, 'James Taggart', 'Dagny Taggart') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (9, 'Lillie Reardon', 'Francisco d''Anconia') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (10, 'Robert Stadler', 'Francisco d''Anconia') ON CONFLICT (id) DO NOTHING;
INSERT INTO employees VALUES (11, 'Cherryl Brooks', 'Francisco d''Anconia') ON CONFLICT (id) DO NOTHING;

INSERT INTO vets VALUES (1, 'James', 'Carter') ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (2, 'Helen', 'Leary') ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (3, 'Linda', 'Douglas') ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (4, 'Rafael', 'Ortega') ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (5, 'Henry', 'Stevens') ON CONFLICT (id) DO NOTHING;
INSERT INTO vets VALUES (6, 'Sharon', 'Jenkins') ON CONFLICT (id) DO NOTHING;

INSERT INTO specialties VALUES (1, 'radiology') ON CONFLICT (id) DO NOTHING;
INSERT INTO specialties VALUES (2, 'surgery') ON CONFLICT (id) DO NOTHING;
INSERT INTO specialties VALUES (3, 'dentistry') ON CONFLICT (id) DO NOTHING;

INSERT INTO vet_specialties VALUES (2, 1) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (3, 2) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (3, 3) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (4, 2) ON CONFLICT (vet_id, specialty_id) DO NOTHING;
INSERT INTO vet_specialties VALUES (5, 1) ON CONFLICT (vet_id, specialty_id) DO NOTHING;

INSERT INTO types VALUES (1, 'cat') ON CONFLICT (id) DO NOTHING;
INSERT INTO types VALUES (2, 'dog') ON CONFLICT (id) DO NOTHING;
INSERT INTO types VALUES (3, 'lizard') ON CONFLICT (id) DO NOTHING;
INSERT INTO types VALUES (4, 'snake') ON CONFLICT (id) DO NOTHING;
INSERT INTO types VALUES (5, 'bird') ON CONFLICT (id) DO NOTHING;
INSERT INTO types VALUES (6, 'hamster') ON CONFLICT (id) DO NOTHING;

INSERT INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435') ON CONFLICT (id) DO NOTHING;
INSERT INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487') ON CONFLICT (id) DO NOTHING;

INSERT INTO pets VALUES (1, 'Leo', '2000-09-07', 1, 1) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (2, 'Basil', '2002-08-06', 6, 2) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (3, 'Rosy', '2001-04-17', 2, 3) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (4, 'Jewel', '2000-03-07', 2, 3) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (5, 'Iggy', '2000-11-30', 3, 4) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (6, 'George', '2000-01-20', 4, 5) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (7, 'Samantha', '1995-09-04', 1, 6) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (8, 'Max', '1995-09-04', 1, 6) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (9, 'Lucky', '1999-08-06', 5, 7) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (10, 'Mulligan', '1997-02-24', 2, 8) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (11, 'Freddy', '2000-03-09', 5, 9) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (12, 'Lucky', '2000-06-24', 2, 10) ON CONFLICT (id) DO NOTHING;
INSERT INTO pets VALUES (13, 'Sly', '2002-06-08', 1, 10) ON CONFLICT (id) DO NOTHING;

INSERT INTO visits VALUES (1, 7, '2010-03-04', 'rabies shot') ON CONFLICT (id) DO NOTHING;
INSERT INTO visits VALUES (2, 8, '2011-03-04', 'rabies shot') ON CONFLICT (id) DO NOTHING;
INSERT INTO visits VALUES (3, 8, '2009-06-04', 'neutered') ON CONFLICT (id) DO NOTHING;
INSERT INTO visits VALUES (4, 7, '2008-09-04', 'spayed') ON CONFLICT (id) DO NOTHING;
