USE covid_db;

UPDATE covid_cases
SET Confirmed_Cases = 45350000
WHERE Country='India'
AND Date='2023-02-01';
