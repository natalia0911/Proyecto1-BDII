 
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 16/04/2021
--- Descripción: Actualizar historial de vendedor
--------------------------------------------------------------------------

CREATE FUNCTION SP_UpdateHistorialVendedor(
       pId INT,
       pComprador INT,
       pSubasta INT,
       pComentario character varying(128),
       pCalificacion INT) returns void
AS $$
BEGIN 
    UPDATE public."HistorialVendedor" AS HC 
    SET
            "Comentario" = pComentario
           ,"Calificacion" = pCalificacion

    WHERE HC."IdVendedor" = pId and HC."IdComprador" = pComprador and HC."IdSubasta" = pSubasta;
--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 