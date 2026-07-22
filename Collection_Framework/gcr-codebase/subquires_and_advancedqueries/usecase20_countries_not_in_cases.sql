-- Use Case 20: Find Countries Present in Deaths but Not Cases
-- Objective: Identify data inconsistencies where countries appear in covid_deaths but not in covid_cases table using NOT IN sub-query.

SELECT DISTINCT
    d.country
FROM 
    covid_deaths d
WHERE 
    d.country NOT IN (
        SELECT DISTINCT c.country
        FROM covid_cases c
    )
ORDER BY 
    d.country;
