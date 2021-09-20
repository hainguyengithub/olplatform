-- Currently using xampp mysql.
-- Run `mysql -u root -p` to have root access.
CREATE DATABASE olplatform;
CREATE USER 'hainguyen'@'%' IDENTIFIED BY 'hainguyen';
GRANT ALL ON olplatform.* TO 'hainguyen'@'%';
-- Note: in case there is 'hainguyen'@'localhost', drop that user:
-- `SELECT user, host FROM mysql.user;`
-- `DROP user 'hainguyen'@'localhost';`
-- See application.properties file.


DROP TABLE class_registration;
DROP TABLE classroom;
DROP TABLE program;
DROP TABLE course;
DROP TABLE administrable;
DROP TABLE person;

-- create academic advisor
