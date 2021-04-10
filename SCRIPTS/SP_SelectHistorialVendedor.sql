

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
       ,HV."IDCOMPRADOR"
       ,HV."IDSUBASTA"
       ,HV."COMENTARIO"
       ,HV."CALIFICACION"

   FROM HISTORIALVENDEDOR HV INNER JOIN USUARIO U ON HV.IDVENDEDOR = U.ID AND HV.IDCOMPRADOR = U.ID
   INNER JOIN SUBASTA S ON HV.IDSUBASTA = S.ID
   
   WHERE HV.IDVENDEDOR = pVendedorId;

COMMIT;
END;
/
