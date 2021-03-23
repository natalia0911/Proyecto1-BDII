
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Inserta un nuevo administrador
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_InsertUser(
       pNombre IN USUARIO.NOMBRE%TYPE,
       pCedula IN USUARIO.CEDULA%TYPE,
       pDireccion IN USUARIO.DIRECCION%TYPE,
       pCorreo IN USUARIO.CORREO%TYPE,
       pEsAdmin IN USUARIO.ESADMIN%TYPE,
       pAlias IN USUARIO.ALIAS%TYPE,
       pContrasennia IN USUARIO.CONTRASENNIA%TYPE)
IS
BEGIN

  INSERT INTO USUARIO 
  (
        "NOMBRE"
       ,"CEDULA"
       ,"DIRECCION"
       ,"CORREO"
       ,"ESADMIN"
       ,"ALIAS"
       ,"CONTRASENNIA"
  ) 
  VALUES 
  (
        pNombre
       ,pCedula
       ,pDireccion
       ,pCorreo
       ,pEsAdmin
       ,pAlias
       ,pContrasennia
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;
/


--SET SERVEROUTPUT ON;
--EXECUTE SP_InsertAdmin('Gustavo',678120700,'Colorado,Guanacaste','gustavobobo@gmail.com',1,'Freuk','FreukBobo123');





