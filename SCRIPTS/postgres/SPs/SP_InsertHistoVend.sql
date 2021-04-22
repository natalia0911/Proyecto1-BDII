
CREATE FUNCTION SP_InsertHistoVend(
    pIdVendedor INT,
    pIdComprador INT,
    pIdSubasta INT
    ) returns void
AS $$
BEGIN 
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
        5        
  );
--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 