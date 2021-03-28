CREATE TABLE ALUMNOS(
    ID NUMBER(5)
        CONSTRAINT ALUMNO_PRIMARY_KEY PRIMARY KEY,
    NOMBRE VARCHAR2(15),
    PAIS VARCHAR2(20),
    FECHA_NACIMIENTO DATE,
    SEXO VARCHAR2(1)
        CONSTRAINT ALUMNO_CHK_SEXO CHECK(SEXO IN('M','H')),
    CURSO VARCHAR2(20)
);

INSERT INTO ALUMNOS VALUES(1,'Pepito Gonzalez','Rumania','5-Mayo-95','H','Bases de datos');
INSERT INTO ALUMNOS VALUES(2,'Laura Sanz','Mexico','14-Abril-86','M','Contabilidad');
INSERT INTO ALUMNOS VALUES(213,'Luis Perez','Argentina','18-May-78','H','Cocina');
INSERT INTO ALUMNOS VALUES(12321,'Susana Perez','España','29-Sep-90','M','Java');
INSERT INTO ALUMNOS VALUES(12322,'Fernando Torres','España','30-Julio-91','H','Java');
INSERT INTO ALUMNOS VALUES(123,'Miriam Ruiz','Cuba','29-Octubre-75','M','Contabilidad');
INSERT INTO ALUMNOS VALUES(129,'Cristian Lopez','España','4-Julio-67','H','Economia');
INSERT INTO ALUMNOS VALUES(6235,'Simone Simons','Holanda','17-Enero-85','M','Ballet');
INSERT INTO ALUMNOS VALUES(10012,'Mustafa Kemal','Turquia','19-Mayo-81','H','Ballet');
INSERT INTO ALUMNOS VALUES(10018,'Mustafa Kemal','Turquia','19-Mayo-81','H','Ballet');


DELETE FROM ALUMNOS WHERE nombre= 'Mustafa Kemal';
SELECT * FROM ALUMNOS WHERE nombre = 'Mustafa Kemal';


CREATE OR REPLACE PROCEDURE ObtenerDatosAlumno(
       p_nombre alumnos.nombre%TYPE, 
       p_sexo OUT alumnos.sexo%TYPE,
       p_curso OUT alumnos.curso%TYPE)
       AS
BEGIN
     SELECT  
            CASE sexo
                 WHEN 'H' THEN 'HOMBRE'
                 ELSE 'MUJER'
            END,
            curso
            INTO p_sexo, p_curso
            FROM alumnos WHERE Nombre = p_nombre;
END;

set serveroutput on;
VARIABLE sex VARCHAR2(1);
VARIABLE cur VARCHAR2(20);
BEGIN
execute ObtenerDatosAlumno('Mustafa Kemal',sex,cur);
END


CREATE OR REPLACE PROCEDURE ObtenerDatosAlumno2(
    cursor OUT SYS_REFCURSOR) AS
BEGIN
     OPEN cursor FOR
     SELECT  

            A.nombre,
            CASE A.sexo
                 WHEN 'H' THEN 'HOMBRE'
                 ELSE 'MUJER'
            END,
            A.curso
            FROM alumnos A;
    --RETURN cursor;
END;



