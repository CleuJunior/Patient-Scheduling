DROP TABLE IF EXISTS patient;

CREATE TABLE patient (
    id serial PRIMARY KEY,
    name varchar(50),
    last_name varchar(100),
    cpf varchar (15),
    email varchar (100)
);

DROP TABLE IF EXISTS schedule;

CREATE TABLE schedule (
    id serial PRIMARY KEY,
    description varchar(255),
    date_hour timestamp,
    date_creation timestamp,
    patient_id integer,
    CONSTRAINT fk_schedule_patient FOREIGN KEY (patient_id) REFERENCES patient(id)
);