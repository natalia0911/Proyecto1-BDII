
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 16/04/2021
--- Descripción: Actualizar historial de vendedor
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_UpdateHistorialVendedor(
       pId IN HISTORIALVENDEDOR.IDVENDEDOR%TYPE,
       pComentario IN HISTORIALVENDEDOR.COMENTARIO%TYPE,
       pCalificacion IN HISTORIALVENDEDOR.CALIFICACION%TYPE)
IS
BEGIN
    UPDATE HISTORIALCOMPRADOR 
    SET
            COMENTARIO = pComentario
           ,CALIFICACION = pCalificacion
           
    WHERE IDVENDEDOR = pId;
COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;
    
END;
/
