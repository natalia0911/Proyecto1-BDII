-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Devolver usuarios
--------------------------------------------------------------------------
create or replace PROCEDURE SP_SelectAllUsers (
       cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        "ID"
       ,"NOMBRE"
       ,"CEDULA"
       ,"DIRECCION"
       ,"CORREO"
       ,"ESADMIN"
       ,"ALIAS"
       ,"CONTRASENNIA"
    FROM USUARIO U;
COMMIT;
END;
/