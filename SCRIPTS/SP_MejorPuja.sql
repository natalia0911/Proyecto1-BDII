

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 09/04/2021
--- Descripción: Dar la mejor puja de una subasta 
--------------------------------------------------------------------------

create or replace NONEDITIONABLE PROCEDURE SP_MejorPuja(
       pSubastaId IN PUJAS.SUBASTAID%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT "ID"
           "PRECIO" 
    FROM (
       SELECT
            P."ID"
           ,P."PRECIO"
       FROM PUJAS P 
       WHERE P.SUBASTAID = pSubastaId
       ORDER BY P.PRECIO DESC
   ) 
   WHERE rownum = 1;

COMMIT;


END;
/

