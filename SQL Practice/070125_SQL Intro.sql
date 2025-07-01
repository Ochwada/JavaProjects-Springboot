CREATE DATABASE w3school_db;

CREATE TABLE
    cars (brand VARCHAR(255), model VARCHAR(255), year INT);

SELECT
    *
FROM
    cars;

INSERT INTO
    cars (brand, model, year)
VALUES
    ('Ford', 'Mustang', 1964);

INSERT INTO
    cars (brand, model, year)
VALUES
    ('Volvo', 'p1800', 1968),
    ('BMW', 'M1', 1978),
    ('Toyota', 'Celica', 1975);

SELECT
    *
FROM
    cars;

SELECT
    brand,
    year
FROM
    cars;

SELECT
    *
FROM
    cars;

ALTER TABLE cars ADD color VARCHAR(255);

UPDATE cars
SET
    color = 'red'
WHERE
    model = 'p1800';

UPDATE cars
SEt
    color = 'white',
    year = 1970
WHERE
    model = 'Celica';

ALTER TABLE cars
ALTER COLUMN year TYPE VARCHAR(4);

ALTER TABLE cars
ALTER COLUMN color TYPE VARCHAR(30);

# Remove the color column
ALTER TABLE cars
DROP COLUMN color;