

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 16/04/2021
--- Descripción: Actualizar historial de comprador
--------------------------------------------------------------------------

create or replace NONEDITIONABLE PROCEDURE SP_UpdateHistorialComprador(
       pId IN HISTORIALCOMPRADOR.IDVENDEDOR%TYPE,
       pComprador IN HISTORIALCOMPRADOR.idcomprador%TYPE,
       pSubasta IN HISTORIALCOMPRADOR.idsubasta%TYPE,
       pComentario IN HISTORIALCOMPRADOR.COMENTARIO%TYPE,
       pCalificacion IN HISTORIALCOMPRADOR.CALIFICACION%TYPE)
IS
BEGIN
    UPDATE HISTORIALCOMPRADOR 
    SET
            COMENTARIO = pComentario
           ,CALIFICACION = pCalificacion

    WHERE IDVENDEDOR = pId and IDCOMPRADOR = pComprador and IDSUBASTA = pSubasta;
COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;
/
