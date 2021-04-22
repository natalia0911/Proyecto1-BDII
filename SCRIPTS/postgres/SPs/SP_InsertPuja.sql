
CREATE FUNCTION SP_InsertPuja(
       pCompradorID INT,
       pSubastaID INT,
       pPrecio INT) returns void
AS $$
BEGIN 
  INSERT INTO PUBLIC."Pujas" 
  (
       "CompradorId"
       ,"SubastaId"
       ,"Precio"
       ,"Fecha"
  ) 
  VALUES 
  (
        pCompradorID
       ,pSubastaID
       ,pPrecio
       ,now()
  );
--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 



