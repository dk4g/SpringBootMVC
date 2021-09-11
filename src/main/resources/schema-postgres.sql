--DROP TABLE IF EXISTS employees;
CREATE TABLE IF NOT EXISTS employees(
employeeid VARCHAR(255) NOT NULL,
firstname VARCHAR(255) NOT NULL,
lastname VARCHAR(255),
country VARCHAR(100),
dateofbirth TIMESTAMP,
PRIMARY KEY(employeeid)
);

--INSERT INTO employees(employeeid, firstname, lastname, country, dateofbirth) VALUES('I1','First','Employee','India', '1980-12-1 00:00:00');