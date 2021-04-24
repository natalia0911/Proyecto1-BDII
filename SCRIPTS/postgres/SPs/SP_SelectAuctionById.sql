
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar subastas
--------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION SP_SelectAuctionById(
       pId INT)
	   returns table
	   (
	    ID INT
       ,UsuarioId INT
       ,SubCategoriaId INT 
       ,PrecioInicial double precision
	   )
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