USE covid_db;

ALTER TABLE covid_cases
ADD vaccination_rate DECIMAL(5,2);

UPDATE covid_cases
SET vaccination_rate=76.50
WHERE Country='India';

UPDATE covid_cases
SET vaccination_rate=69.80
WHERE Country='USA';

UPDATE covid_cases
SET vaccination_rate=81.20
WHERE Country='UK';
