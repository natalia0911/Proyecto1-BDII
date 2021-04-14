create or replace NONEDITIONABLE PROCEDURE SP_InsertHistoVend(
    pIdVendedor in historialvendedor.idvendedor%TYPE,
    pIdComprador in historialvendedor.idcomprador%TYPE,
    pIdSubasta in historialvendedor.idsubasta%TYPE
    )
IS
BEGIN

  INSERT INTO HISTORIALVENDEDOR 
  (
       IDVENDEDOR,
       IDCOMPRADOR,
       IDSUBASTA,
       CALIFICACION
  ) 
  VALUES 
  (
        pIdVendedor,
        pIdComprador,
        pIdSubasta,
        5        --Empieza estando activa
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

