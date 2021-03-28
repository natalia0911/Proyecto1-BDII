
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar las pujas de una determinada subasta 
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SelectPujas(
       pSubastaId IN PUJAS.SUBASTAID%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        "ID"
       ,"COMPRADORID"
       ,"SUBASTAID"
       ,"PRECIO"
       ,"FECHA"

   FROM PUJAS P
   WHERE P.SUBASTAID = pSubastaId
   ORDER BY P.FECHA DESC;
  
COMMIT;


END;
/


