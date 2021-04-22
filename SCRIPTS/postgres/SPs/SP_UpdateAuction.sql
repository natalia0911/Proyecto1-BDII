
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Actualiza una subasta que se inactiva
--------------------------------------------------------------------------

CREATE FUNCTION SP_UpdateAuction(
       pId INT,
       pIdGanador INT,
       pPrecioFinal NUMERIC)returns void

AS $$
BEGIN 

    UPDATE public."Subasta" AS S
    SET
            "PrecioFinal" = pPrecioFinal
           ,"IdGanador" = pIdGanador
           ,"Activa" = FALSE
           
    WHERE S."ID" = pId;

--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 