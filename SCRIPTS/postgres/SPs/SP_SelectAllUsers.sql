-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Devolver usuarios
--------------------------------------------------------------------------
CREATE PROCEDURE SP_SelectAllUsers ()  

LANGUAGE SQL
AS $$

    SELECT 
        "Id"
       ,"Nombre"
       ,"Cedula"
       ,"Direccion"
       ,"Correo"
       ,"EsAdmin"
       ,"Alias"
       ,"contraseña"
    FROM public."Usuario" U;
$$;
  COMMIT;
END;

