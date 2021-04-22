
CREATE FUNCTION SP_InsertHistoComp(
    pIdComprador INT,
    pIdVendedor INT,
    pIdSubasta INT
    ) returns void
AS $$
BEGIN 
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
        5        
  );
--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 