

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 16/04/2021
--- Descripción: Actualizar historial de comprador
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
