use schedule;

## Tabela de Pacientes
CREATE TABLE patient (
    id serial PRIMARY KEY,
    name varchar(50),
    lastname varchar(100),
    cpf varchar (15),
    email varchar (100)
);

## Tabela de Agenda
CREATE TABLE schedule (
    id serial PRIMARY KEY,
    description varchar(255),
    date_hour timestamp,
    date_creation timestamp,
    patient_id integer,
    CONSTRAINT fk_schedule_patient FOREIGN KEY (patient_id) REFERENCES patient(id)
);