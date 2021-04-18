CREATE PROCEDURE SP_InsertHistoVend(
    pIdVendedor INT,
    pIdComprador INT,
    pIdSubasta INT
    )
LANGUAGE SQL
AS $$
  INSERT INTO public."HistorialVendedor" 
  (
       "IdVendedor",
       "IdComprador",
       "IdSubasta",
       "Calificacion"
  ) 
  VALUES 
  (
        pIdVendedor,
        pIdComprador,
        pIdSubasta,
        5        --Empieza estando activa
  );

$$;
  COMMIT;
--  END;
--	  EXCEPTION WHEN OTHERS THEN
--  	   ROLLBACK;

END;
