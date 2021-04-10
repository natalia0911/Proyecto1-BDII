
-------------------------------------------------------------------------
--- Creado por: Gustavo Orozco
--- Fecha creaci�n: 09/04/2021
--- Descripci�n: Insertar puja
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_InsertPuja(
       pCompradorID IN PUJAS.COMPRADORID%TYPE,
       pSubastaID IN PUJAS.SUBASTAID%TYPE,
       pPrecio IN PUJAS.PRECIO%TYPE)
IS
BEGIN

  INSERT INTO PUJAS 
  (
       "COMPRADORID"
       ,"SUBASTAID"
       ,"PRECIO"
       ,"FECHA"
  ) 
  VALUES 
  (
        pCompradorID
       ,pSubastaID
       ,pPrecio
       ,SYSDATE
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;
/
