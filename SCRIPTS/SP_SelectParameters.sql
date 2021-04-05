

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 05/04/2021
--- Descripción: Listar parametros
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SelectParameters(
       cursor OUT SYS_REFCURSOR)
IS
BEGIN
     OPEN cursor FOR
     SELECT 
        "CODPARAMETER"
       ,"VALOR"
    FROM SYSTEMPARAMETERS;
COMMIT;
END;
/