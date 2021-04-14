create or replace NONEDITIONABLE PROCEDURE SP_InsertHistoComp(
    pIdComprador in historialvendedor.idcomprador%TYPE,
    pIdVendedor in historialvendedor.idvendedor%TYPE,
    pIdSubasta in historialvendedor.idsubasta%TYPE
    )
IS
BEGIN

  INSERT INTO HISTORIALCOMPRADOR 
  (
       IDCOMPRADOR,
       IDVENDEDOR,
       IDSUBASTA,
       CALIFICACION
  ) 
  VALUES 
  (
        pIdComprador,
        pIdVendedor,
        pIdSubasta,
        5        --Empieza estando activa
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

