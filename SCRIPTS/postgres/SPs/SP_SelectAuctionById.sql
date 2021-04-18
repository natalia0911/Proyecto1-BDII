
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar subastas
--------------------------------------------------------------------------

CREATE PROCEDURE SP_SelectAuctionById(
       pId INT)

LANGUAGE SQL
AS $$
     SELECT 
        "ID"
       ,"UsuarioId"
       ,"SubCategoriaId"
       ,"PrecioInicial"

    FROM  public."Subasta" AS S
    WHERE S."ID" = pId;
$$;
  COMMIT;
END;
