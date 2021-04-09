CREATE OR REPLACE PROCEDURE SP_InsertPuja(
       pCompradorID IN pujas.compradorid%TYPE,
       pSubastaID IN pujas.subastaid%TYPE,
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
