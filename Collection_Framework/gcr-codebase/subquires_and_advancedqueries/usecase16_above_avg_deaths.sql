-- Use Case 16: Find Countries with Above-Average Death Counts
-- Objective: Identify countries with a death count exceeding the global average using a sub-query.

SELECT 
    country,
    SUM(total_deaths) AS total_death_count
FROM 
    covid_deaths
GROUP BY 
    country
HAVING 
    SUM(total_deaths) > (
        SELECT AVG(total_death_sum)
        FROM (
            SELECT SUM(total_deaths) AS total_death_sum
            FROM covid_deaths
            GROUP BY country
        ) AS country_deaths
    )
ORDER BY 
    total_death_count DESC;
