-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 30/03/2021
--- Descripción: Devolver todas las categorias
--------------------------------------------------------------------------
CREATE PROCEDURE SP_SelectCategories ()
LANGUAGE SQL
AS $$

    SELECT 
        "Id"
       ,"Nombre"

    FROM "Categoria";
$$;
  COMMIT;

END;