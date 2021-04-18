
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar subastas
--------------------------------------------------------------------------

CREATE PROCEDURE SP_SelectAuction(
       pSubCat INT)

LANGUAGE SQL
AS $$
     SELECT 
        S."ID"
       ,S."UsuarioId"
       ,U."Alias"
       ,S."SubCategoriaId"
       ,C."Nombre"
       ,S."PrecioInicial"
       ,S."PrecioFinal"
       ,S."DetallesEntrega"
       ,S."FechaInicio"
       ,S."FechaFin"

    FROM public."Subasta" AS S INNER JOIN public."SubCategoria" AS C ON S."SubCategoriaId" = C."Id"
    INNER JOIN public."Usuario" AS U ON S."UsuarioId" = U."Id"
    
    WHERE S."Activa" = TRUE and S."SubCategoriaId" = pSubCat
    ORDER BY S."FechaInicio" ASC;
  
$$;
  COMMIT;
END;