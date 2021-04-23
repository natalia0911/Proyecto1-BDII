CREATE FUNCTION SP_SelectMiHistoVend(
    miID INT)
	returns TABLE
	(
	    IdVendedor INT
       ,NombreV  character varying(128)
       ,IdComprador INT
       ,NombreC character varying(128)
       ,IdSubasta INT
       ,PrecioInicial NUMERIC
       ,PrecioFinal NUMERIC
       ,Comentario character varying(128)
       ,Calificacion INT
       ,FechaFin DATE
	   )
AS $$
BEGIN 
	RETURN QUERY
    SELECT 
        HV."IdVendedor"
       ,UV."Nombre"
       ,HV."IdComprador"
       ,UC."Nombre"
       ,HV."IdSubasta"
       ,S."PrecioInicial"
       ,S."PrecioFinal"
       ,HV."Comentario"
       ,HV."Calificacion"
       ,S."FechaFin"

   FROM public."HistorialVendedor" HV INNER JOIN public."Usuario" UV ON HV."IdVendedor" = UV."Id" 
   INNER JOIN public."Usuario" UC ON HV."IdComprador" = UC."Id"
   INNER JOIN public."Subasta" AS S ON HV."IdSubasta" = S."ID"

   WHERE HV."IdComprador" = miID;
END;
$$
LANGUAGE plpgsql