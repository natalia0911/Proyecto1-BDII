-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 21/03/2021
--- Descripci�n: Devolver usuario que cumple con alias y contrasennia
--------------------------------------------------------------------------
create or replace PROCEDURE SP_SelectUsers (
       pAlias IN USUARIO.ALIAS%TYPE,
       pContrasennia IN USUARIO.CONTRASENNIA%TYPE,
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
    FROM USUARIO U
    WHERE U.ALIAS = pAlias AND U.CONTRASENNIA = pContrasennia;
COMMIT;
END;
/