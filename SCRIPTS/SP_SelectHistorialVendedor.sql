

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 09/04/2021
--- Descripción: Listar el historial de un vendedor
--------------------------------------------------------------------------

create or replace NONEDITIONABLE PROCEDURE SP_SelectHistorialVendedor(
       pVendedorId IN HISTORIALVENDEDOR.IDVENDEDOR%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        HV."IDVENDEDOR"
       ,UV."NOMBRE"
       ,HV."IDCOMPRADOR"
       ,UC."NOMBRE"
       ,HV."IDSUBASTA"
       ,S."PRECIOINICIAL"
       ,S."PRECIOFINAL"
       ,HV."COMENTARIO"
       ,HV."CALIFICACION"

   FROM HISTORIALVENDEDOR HV INNER JOIN USUARIO UV ON HV.IDVENDEDOR = UV.ID 
   INNER JOIN USUARIO UC ON HV.IDCOMPRADOR = UC.ID
   INNER JOIN SUBASTA S ON HV.IDSUBASTA = S.ID
   
   WHERE HV.IDVENDEDOR = pVendedorId;

COMMIT;
END;
/
