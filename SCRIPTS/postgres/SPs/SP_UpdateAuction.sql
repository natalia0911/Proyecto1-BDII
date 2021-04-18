
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Actualiza una subasta que se inactiva
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_UpdateAuction(
       pId INT,
       pIdGanador INT,
       pPrecioFinal NUMERIC)
	   
LANGUAGE SQL
AS $$

    UPDATE public."Subasta" AS S
    SET
            "PrecioFinal" = pPrecioFinal
           ,"IdGanador" = pIdGanador
           ,"Activa" = FALSE
           
    WHERE S."ID" = pId;

$$;
  COMMIT;
--  END;
--	  EXCEPTION WHEN OTHERS THEN
--  	   ROLLBACK;

END;