CREATE DATABASE quanlyPhim;
use quanlyPhim;

CREATE TABLE movie (
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255),
	description VARCHAR(255),
	length INT,
	rating ENUM ('G','PG','PG-13','R','NC-17','NR') DEFAULT 'G',
	poster VARCHAR(255),
	studio VARCHAR(255),
	status ENUM ('Public', 'Hidden') DEFAULT 'Public',
	release_date DATE,
	id_director INT,
	PRIMARY KEY (id),
    FOREIGN KEY (id_director) REFERENCES director(id)
);

CREATE TABLE movie_actor (
	id_movie INT ,
    id_actor INT ,
    FOREIGN KEY (id_movie) REFERENCES movie(id),
    FOREIGN KEY (id_actor) REFERENCES actor(id)
);

CREATE TABLE actor (
	id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE movie_category (
	id_movie INT ,
    id_category INT ,
    FOREIGN KEY (id_movie) REFERENCES movie(id),
    FOREIGN KEY (id_category) REFERENCES category(id)
);

CREATE TABLE movie_format (
	id_movie INT ,
    id_format INT ,
    FOREIGN KEY (id_movie) REFERENCES movie(id),
    FOREIGN KEY (id_format) REFERENCES format(id)
);

CREATE TABLE movie_language (
	id_movie INT ,
    id_category INT ,
    FOREIGN KEY (id_movie) REFERENCES movie(id),
    FOREIGN KEY (id_category) REFERENCES language(id)
);

CREATE TABLE director (
	id INT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE category (
	id INT NOT NULL AUTO_INCREMENT,
    full_name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE format (
	id INT NOT NULL AUTO_INCREMENT,
	name ENUM ('2D', '3D') DEFAULT '2D',
    PRIMARY KEY (id)
);

CREATE TABLE language (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE trailer (
	id INT NOT NULL AUTO_INCREMENT,
	id_movie INT,
    PRIMARY KEY (id),
    FOREIGN KEY (id_movie) REFERENCES movie(id)
);