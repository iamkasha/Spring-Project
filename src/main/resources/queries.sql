CREATE TABLE Employee(first_name varchar(25),
last_name varchar(25), job_start_date date, salary integer
);

ALTER TABLE Employee
ADD COLUMN department VARCHAR(50);

SELECT MAX(salary) AS highest_salary
FROM Employee;

SELECT *
FROM Employee
WHERE job_start_date >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH);

SELECT department, COUNT(*) AS employee_count
FROM Employee
GROUP BY department;


UPDATE consultant_detail
SET email_address = 'naraint@gmail.com'
WHERE first_name = 'narain';

SELECT consultant_id, COUNT(*) AS total_submissions
FROM submission
GROUP BY consultant_id;

SELECT submission_date, consultant_id, COUNT(*) AS total_submissions
FROM submission
GROUP BY submission_date, consultant_id;

DELETE FROM submission WHERE pay_rate IS NULL;

SELECT s.*
FROM lead_detail l
JOIN consultant_detail c ON l.id = c.lead_id
JOIN submission s ON c.id = s.consultant_id
WHERE l.first_name = 'Vinay'
AND s.submission_date = '2023-07-17';

SELECT l.first_name, count(s.id) as submission_count
FROM lead_detail l
JOIN consultant_detail c ON l.id = c.lead_id
JOIN submission s ON c.id = s.consultant_id
WHERE l.first_name = 'Vinay'
AND s.submission_date = '2023-07-17'
GROUP BY l.first_name;