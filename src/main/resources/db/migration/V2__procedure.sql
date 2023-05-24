CREATE OR REPLACE PROCEDURE InsertPatient(
    p_name varchar(50),
    p_last_name varchar(100),
    p_cpf varchar(15),
    p_email varchar(100)
)
LANGUAGE plpgsql
AS $$
BEGIN
INSERT INTO patient (name, last_name, cpf, email)
VALUES (p_name, p_last_name, p_cpf, p_email);
END;
$$;

CREATE OR REPLACE PROCEDURE InsertSchedule(
    p_description VARCHAR(255),
    p_date_hour TIMESTAMP,
    p_patient_id INTEGER
)

LANGUAGE plpgsql
AS $$
BEGIN
    INSERT INTO schedule (description, date_hour, date_creation, patient_id)
    VALUES (p_description, p_date_hour, NOW(), p_patient_id);
END;
$$;
