CREATE schema IF NOT EXISTS socgen;

DROP TABLE IF EXISTS socgen.socgen_employees;

CREATE TABLE socgen.socgen_employees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  gender VARCHAR(1) NOT NULL,
  dob DATE NOT NULL,
  department VARCHAR2(100)
);