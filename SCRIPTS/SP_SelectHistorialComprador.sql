

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 09/04/2021
--- Descripción: Listar el historial de un Comprador
--------------------------------------------------------------------------

create or replace NONEDITIONABLE PROCEDURE SP_SelectHistorialComprador(
       pcompradorId IN HISTORIALVENDEDOR.IDCOMPRADOR%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        HC."IDCOMPRADOR"
       ,HC."IDVENDEDOR"
       ,HC."IDSUBASTA"
       ,HC."COMENTARIO"
       ,HC."CALIFICACION"

   FROM HISTORIALVENDEDOR HC INNER JOIN USUARIO U ON HC.IDVENDEDOR = U.ID AND HC.IDCOMPRADOR = U.ID
   INNER JOIN SUBASTA S ON HC.IDSUBASTA = S.ID
   
   WHERE HC.IDCOMPRADOR = pcompradorId;

COMMIT;
END;
/
