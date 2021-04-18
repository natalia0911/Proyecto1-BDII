
CREATE PROCEDURE SP_InsertHistoComp(
    pIdComprador INT,
    pIdVendedor INT,
    pIdSubasta INT
    )
LANGUAGE SQL
AS $$

  INSERT INTO public."HistorialComprador"
  (
       "IdComprador",
       "IdVendedor",
       "IdSubasta",
       "Calificacion"
  ) 
  VALUES 
  (
        pIdComprador,
        pIdVendedor,
        pIdSubasta,
        5        --Empieza estando activa
  );

$$;
  COMMIT;
--  END;
--	  EXCEPTION WHEN OTHERS THEN
--  	   ROLLBACK;

END;