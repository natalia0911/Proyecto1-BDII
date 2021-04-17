

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
       ,UV."NOMBRE"
       ,HC."IDVENDEDOR"
       ,UC."NOMBRE"
       ,HC."IDSUBASTA"
       ,S."PRECIOINICIAL"
       ,S."PRECIOFINAL"
       ,HC."COMENTARIO"
       ,HC."CALIFICACION"

   FROM HISTORIALCOMPRADOR HC INNER JOIN USUARIO UC ON HC.IDCOMPRADOR = UC.ID 
   INNER JOIN USUARIO UV ON HC.IDVENDEDOR = UV.ID
   INNER JOIN SUBASTA S ON HC.IDSUBASTA = S.ID
   
   WHERE HC.IDCOMPRADOR = pcompradorId;

COMMIT;
END;
/
