show databases;

create database medicaldb;
USE medicaldb;

CREATE TABLE patient(
id int PRIMARY KEY auto_increment,
name varchar(100),
gender varchar(10),
last_name varchar(100),
age int,
email varchar(100),
patient_type varchar(50)
);

DROP TABLE patient;

INSERT INTO patient(name, gender,last_name,age,email,patient_type) 
VALUES ('Ritvij','Male','Naram',24,'ritvijnaram@gmail.com','new_patient');

UPDATE patient SET name=?, gender=?, last_name=?, age=?, email=?, patient_type=?;
UPDATE patient SET name=?, gender=Raj, last_name=naram, age=22, email= rajgmailcom, patient_type=Walk-in WHERE id= 4; 

SELECT * FROM patient;
DELETE FROM patient WHERE id=?
