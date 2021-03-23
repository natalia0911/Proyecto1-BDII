

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 21/03/2021
--- Descripci�n: Actualiza una subasta que se inactiva
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_UpdateAuction(
       pId IN SUBASTA.ID%TYPE,
       pPrecioFinal IN SUBASTA.PRECIOFINAL%TYPE)
IS
BEGIN
    UPDATE SUBASTA 
    SET
            PRECIOFINAL = pPrecioFinal
           ,ACTIVA = 0
    WHERE ID = pId;
COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;
    
END;
/
