-- Use Case 17: Identify Countries Exceeding Case Threshold
-- Objective: Find countries where maximum confirmed cases exceed 1 million using a sub-query with IN operator.

SELECT 
    country,
    MAX(confirmed_cases) AS max_confirmed_cases
FROM 
    covid_cases
GROUP BY 
    country
HAVING 
    MAX(confirmed_cases) > 1000000
ORDER BY 
    max_confirmed_cases DESC;
