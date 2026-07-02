USE covid_db;

-- Delete incorrect country entry

DELETE FROM covid_cases
WHERE Country='IN';

-- Delete duplicate records

DELETE c1
FROM covid_cases c1
JOIN covid_cases c2
ON c1.Country=c2.Country
AND c1.Date=c2.Date
AND c1.Confirmed_Cases=c2.Confirmed_Cases
AND c1.Deaths=c2.Deaths
AND c1.Recoveries=c2.Recoveries
AND c1.Population=c2.Population
WHERE c1.rowid > c2.rowid;
