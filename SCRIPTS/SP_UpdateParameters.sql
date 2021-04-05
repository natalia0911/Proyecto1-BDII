
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 25/04/2021
--- Descripci�n: Actualiza parametros del sistema
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_UpdateParameters(
       pCodParameter IN SYSTEMPARAMETERS.CODPARAMETER%TYPE,
       pNewValue IN SYSTEMPARAMETERS.VALOR%TYPE)
IS
BEGIN
    UPDATE SYSTEMPARAMETERS 
    SET
        VALOR = pNewValue
    WHERE CODPARAMETER = pCodParameter;
COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;
    
END;
/
