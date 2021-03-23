


-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar las pujas de una determinada subasta 
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SelectPujas(
       pSubastaId IN PUJAS.SUBASTAID%TYPE)
       
IS
BEGIN

   SELECT 
        "ID"
       ,"COMPRADORID"
       ,"SUBASTAID"
       ,"PRECIO"
       ,"PRECIOFINAL"
       ,"FECHA"

  FROM PUJAS P
  WHERE P.SUBASTAID = pSubastaId
  ORDER BY S.FECHA DESC;
  
COMMIT;


END;
/