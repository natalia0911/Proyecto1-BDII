-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 30/03/2021
--- Descripción: Devolver todas las categorias
--------------------------------------------------------------------------
CREATE FUNCTION SP_SelectCategories ()
	returns setof public."Categoria"
	
AS $$
BEGIN 
	RETURN QUERY
    SELECT 
        "Id"
       ,"Nombre"

    FROM public."Categoria";
END;
$$
LANGUAGE plpgsql