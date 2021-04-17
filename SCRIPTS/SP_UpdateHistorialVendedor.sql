
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 16/04/2021
--- Descripción: Actualizar historial de vendedor
--------------------------------------------------------------------------

create or replace NONEDITIONABLE PROCEDURE SP_UpdateHistorialVendedor(
       pId IN HISTORIALVENDEDOR.IDVENDEDOR%TYPE,
       pComprador IN historialvendedor.idcomprador%TYPE,
       pSubasta IN historialvendedor.idsubasta%TYPE,
       pComentario IN HISTORIALVENDEDOR.COMENTARIO%TYPE,
       pCalificacion IN HISTORIALVENDEDOR.CALIFICACION%TYPE)
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
