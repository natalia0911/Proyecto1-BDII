

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 05/04/2021
--- Descripci�n: Listar parametros
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