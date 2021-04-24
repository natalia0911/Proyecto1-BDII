

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 09/04/2021
--- Descripción: Listar el historial de un vendedor
--------------------------------------------------------------------------

CREATE FUNCTION SP_SelectHistorialVendedor(
    pVendedorId INT)
    returns table
	(
	 IdVendedor INT
    ,NombreV character varying(128)
    ,IdComprador INT
    ,NombreC character varying(128)
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
        HV."IdVendedor"
       ,UV."Nombre"
       ,HV."IdComprador"
       ,UC."Nombre"
       ,HV."IdSubasta"
       ,S."PrecioInicial"
       ,S."PrecioFinal"
       ,HV."Comentario"
       ,HV."Calificacion"

   FROM public."HistorialVendedor" AS HV INNER JOIN public."Usuario" AS UV ON HV."IdVendedor" = UV."Id" 
   INNER JOIN public."Usuario" AS UC ON HV."IdComprador" = UC."Id"
   INNER JOIN public."Subasta" AS S ON HV."IdSubasta" = S."ID"

   WHERE HV."IdVendedor" = pVendedorId;
END;
$$
LANGUAGE plpgsql
