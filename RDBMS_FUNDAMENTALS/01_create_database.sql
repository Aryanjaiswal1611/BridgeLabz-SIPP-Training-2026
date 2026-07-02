CREATE DATABASE covid_db;

USE covid_db;

CREATE TABLE covid_cases (
    Country VARCHAR(50),
    Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    Population BIGINT
);

CREATE TABLE covid_deaths (
    Country VARCHAR(50),
    Date DATE,
    Deaths INT
);

CREATE TABLE covid_vaccines (
    Country VARCHAR(50),
    Date DATE,
    Vaccinated_People INT,
    Total_Doses INT
);
