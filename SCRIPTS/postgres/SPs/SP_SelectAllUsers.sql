-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Devolver usuarios
--------------------------------------------------------------------------
CREATE FUNCTION SP_SelectAllUsers ()  
returns setof public."Usuario"

AS $$
BEGIN
	RETURN QUERY
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
END;
$$
LANGUAGE plpgsql

