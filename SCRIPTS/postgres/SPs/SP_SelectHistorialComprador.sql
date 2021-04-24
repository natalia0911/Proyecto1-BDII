
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 09/04/2021
--- Descripción: Listar el historial de un Comprador
--------------------------------------------------------------------------

CREATE FUNCTION SP_SelectHistorialComprador(
    pcompradorId INT)
    returns TABLE
	(  
	    IdComprador INT
       ,NombreC character varying(128)
       ,IdVendedor INT
       ,NombreV character varying(128)
       ,IdSubasta INT
       ,PrecioInicial double precision
       ,PrecioFinal double precision
       ,Comentario character varying(128)
       ,Calificacion INT
	)
AS $$
BEGIN 
	RETURN QUERY
    SELECT 
        HC."IdComprador"
       ,UC."Nombre"
       ,HC."IdVendedor"
       ,UV."Nombre"
       ,HC."IdSubasta"
       ,S."PrecioInicial"
       ,S."PrecioFinal"
       ,HC."Comentario"
       ,HC."Calificacion"

   FROM public."HistorialComprador" AS HC INNER JOIN public."Usuario" AS UC ON HC."IdComprador" = UC."Id" 
   INNER JOIN public."Usuario" AS UV ON HC."IdVendedor" = UV."Id"
   INNER JOIN public."Subasta" AS S ON HC."IdSubasta" = S."ID"
   
   WHERE HC."IdComprador" = pcompradorId;

END;
$$
LANGUAGE plpgsql



