
CREATE PROCEDURE SP_InsertPuja(
       pCompradorID INT,
       pSubastaID INT,
       pPrecio INT)
LANGUAGE SQL
AS $$

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

$$;
  COMMIT;
--  END;
--	  EXCEPTION WHEN OTHERS THEN
--  	   ROLLBACK;

END;




