
CREATE FUNCTION SP_SelectMiHistoComp(
    miID INT)
	returns setof public."HistorialComprador"
AS $$
BEGIN 
	RETURN QUERY
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
       ,S."FechaFin"

   FROM public."HistorialComprador" AS HC INNER JOIN public."Usuario" AS UV ON HC."IdComprador" = UV."Id" 
   INNER JOIN public."Usuario" AS UC ON HC."IdComprador" = UC."Id"
   INNER JOIN public."Subasta" AS S ON HC."IdSubasta" = S."ID"

   WHERE HC."IdVendedor" = miID;
END;
$$
LANGUAGE plpgsql
