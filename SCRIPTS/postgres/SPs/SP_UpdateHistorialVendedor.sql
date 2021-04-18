 
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 16/04/2021
--- Descripción: Actualizar historial de vendedor
--------------------------------------------------------------------------

CREATE PROCEDURE SP_UpdateHistorialVendedor(
       pId INT,
       pComprador INT,
       pSubasta INT,
       pComentario character varying(128),
       pCalificacion INT)
LANGUAGE SQL
AS $$
    UPDATE public."HistorialVendedor" AS HC 
    SET
            "Comentario" = pComentario
           ,"Calificacion" = pCalificacion

    WHERE HC."IdVendedor" = pId and HC."IdComprador" = pComprador and HC."IdSubasta" = pSubasta;
$$;
  COMMIT;
--  END;
--	  EXCEPTION WHEN OTHERS THEN
--  	   ROLLBACK;

END;