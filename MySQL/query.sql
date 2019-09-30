SELECT e.name, 'руководит ', d.name, 'а числится ', d1.name FROM learn.employee e
JOIN learn.department d ON e.id = d.head_id AND e.department_id != d.id
JOIN learn.department d1 ON e.department_id = d1.id;

SELECT e.name, d.name, e.salary FROM learn.employee e
JOIN learn.department d ON e.id = d.head_id AND e.salary < 115000

SELECT e.name, d.name, e.hire_date FROM learn.employee e
JOIN learn.department d ON e.id = d.head_id AND e.hire_date < '2010-03-01'



