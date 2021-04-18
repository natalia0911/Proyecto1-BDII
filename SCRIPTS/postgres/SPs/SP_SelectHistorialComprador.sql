
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 09/04/2021
--- Descripción: Listar el historial de un Comprador
--------------------------------------------------------------------------

CREATE PROCEDURE SP_SelectHistorialComprador(
       pcompradorId INT)
       
LANGUAGE SQL
AS $$

    SELECT 
        HC."IdComprador"
       ,UV."Nombre"
       ,HC."IdVendedor"
       ,UC."Nombre"
       ,HC."IdSubasta"
       ,S."PrecioInicial"
       ,S."PrecioFinal"
       ,HC."Comentario"
       ,HC."Calificacion"

   FROM public."HistorialComprador" AS HC INNER JOIN public."Usuario" AS UC ON HC."IdComprador" = UC."Id" 
   INNER JOIN public."Usuario" AS UV ON HC."IdVendedor" = UV."Id"
   INNER JOIN public."Subasta" AS S ON HC."IdSubasta" = S."ID"
   
   WHERE HC."IdComprador" = pcompradorId;

$$;
  COMMIT;
END;
