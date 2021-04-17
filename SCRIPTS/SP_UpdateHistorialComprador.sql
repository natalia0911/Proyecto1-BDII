

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 16/04/2021
--- Descripci�n: Actualizar historial de comprador
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_UpdateHistorialComprador(
       pId IN HISTORIALCOMPRADOR.IDCOMPRADOR%TYPE,
       pComentario IN HISTORIALCOMPRADOR.COMENTARIO%TYPE,
       pCalificacion IN HISTORIALCOMPRADOR.CALIFICACION%TYPE)
IS
BEGIN
    UPDATE HISTORIALCOMPRADOR 
    SET
            COMENTARIO = pComentario
           ,CALIFICACION = pCalificacion
           
    WHERE IDCOMPRADOR = pId;
COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;
    
END;
/
