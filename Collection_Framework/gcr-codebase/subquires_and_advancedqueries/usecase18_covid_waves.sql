-- Use Case 18: Track COVID Waves - State-wise Analysis
-- Objective: Track whether each day represents a peak in confirmed cases for a specific state like 'Mumbai' using a correlated sub-query.

SELECT 
    c1.record_date,
    c1.confirmed_cases,
    c1.state
FROM 
    covid_cases c1
WHERE 
    c1.state = 'Mumbai'
    AND c1.confirmed_cases = (
        SELECT MAX(c2.confirmed_cases)
        FROM covid_cases c2
        WHERE c2.state = c1.state
          AND c2.record_date BETWEEN DATEADD(DAY, -3, c1.record_date) 
                                 AND DATEADD(DAY, 3, c1.record_date)
    )
ORDER BY 
    c1.record_date;
