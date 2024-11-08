CREATE database systembooks;

use systembooks;

CREATE TABLE autor (
	Id INT NOT NULL AUTO_INCREMENT,
	Name VARCHAR(255),
    Email VARCHAR(255),
    PRIMARY KEY (Id)
);

CREATE TABLE book (
	Id INT NOT NULL AUTO_INCREMENT,
    Title VARCHAR(255),
    Price DECIMAL,
    AutorId INT,
    PRIMARY KEY (Id),
    FOREIGN KEY (AutorId) REFERENCES autor(Id)
)

SELECT * FROM autor;

SELECT * FROM book;

SELECT book.*, autor.Name, autor.Email FROM book INNER JOIN autor ON book.AutorId = autor.Id WHERE book.Id = 1;