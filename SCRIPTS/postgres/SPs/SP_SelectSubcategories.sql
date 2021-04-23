

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 30/03/2021
--- Descripción: Devolver todas las subcategorias de una categoria dada
--------------------------------------------------------------------------
CREATE FUNCTION SP_SelectSubcategories (
    pCategoriaId INT) returns setof public."SubCategoria"
AS $$
BEGIN 
	RETURN QUERY
    SELECT 
        "Id"
       ,"Nombre"
	   ,"CategoriaId"

    FROM public."SubCategoria" AS S
    WHERE S."CategoriaId" = pCategoriaId;
END;
$$
LANGUAGE plpgsql
