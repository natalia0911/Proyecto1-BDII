
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 21/03/2021
--- Descripci�n: Listar las pujas de una determinada subasta 
--------------------------------------------------------------------------

create or replace NONEDITIONABLE PROCEDURE SP_SelectPujas(
       pSubastaId IN PUJAS.SUBASTAID%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        P."ID"
       ,P."COMPRADORID"
       ,U."NOMBRE"
       ,P."SUBASTAID"
       ,P."PRECIO"
       ,P."FECHA"

   FROM PUJAS P INNER JOIN USUARIO U ON P.COMPRADORID = U.ID
   WHERE P.SUBASTAID = pSubastaId
   ORDER BY P.FECHA DESC;

COMMIT;


END;
/

