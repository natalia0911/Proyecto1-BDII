
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar subastas
--------------------------------------------------------------------------

CREATE FUNCTION SP_SelectAuctionById(
       pId INT)
	   returns setof public."Subasta"
AS $$
BEGIN 
	RETURN QUERY
     SELECT 
        "ID"
       ,"UsuarioId"
       ,"SubCategoriaId"
       ,"PrecioInicial"

    FROM  public."Subasta" AS S
    WHERE S."ID" = pId;
END;
$$
LANGUAGE plpgsql