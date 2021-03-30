
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 21/03/2021
--- Descripci�n: Actualiza un usuario
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_UpdateUser(
       pNombre IN USUARIO.NOMBRE%TYPE,
       pCedula IN USUARIO.CEDULA%TYPE,
       pDireccion IN USUARIO.DIRECCION%TYPE,
       pCorreo IN USUARIO.CORREO%TYPE,
       pAlias IN USUARIO.ALIAS%TYPE,
       pContrasennia IN USUARIO.CONTRASENNIA%TYPE)
IS
BEGIN
    UPDATE USUARIO 
    SET
            NOMBRE = pNombre
           ,DIRECCION = pDireccion
           ,CORREO = pCorreo
           ,ALIAS = pAlias
           ,CONTRASENNIA = pContrasennia
    WHERE CEDULA = pCedula;
COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;
    
END;
/

--execute SP_UpdateUser('Vanessa',12363,'Pital','naty@gmail.com','hawk','hawk');
