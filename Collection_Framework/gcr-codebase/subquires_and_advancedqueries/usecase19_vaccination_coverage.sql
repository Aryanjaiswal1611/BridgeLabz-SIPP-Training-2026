-- Use Case 19: Compare Vaccination Coverage
-- Objective: Perform comprehensive coverage analysis by combining vaccinated and unvaccinated population counts using UNION.

SELECT 
    country,
    'Vaccinated' AS coverage_status,
    SUM(people_vaccinated) AS population_count
FROM 
    covid_vaccinations
GROUP BY 
    country

UNION

SELECT 
    country,
    'Unvaccinated' AS coverage_status,
    MAX(population) - SUM(people_vaccinated) AS population_count
FROM 
    covid_vaccinations
GROUP BY 
    country
ORDER BY 
    country, coverage_status;
