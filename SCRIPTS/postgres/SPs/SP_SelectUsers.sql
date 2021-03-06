
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Devolver usuario que cumple con alias y contrasennia
--------------------------------------------------------------------------
CREATE FUNCTION SP_SelectUsers (
       pAlias character varying(20),
       pContrasennia character varying(16)) 
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
    FROM public."Usuario" AS U
    WHERE U."Alias" = pAlias AND U."contraseña" = pContrasennia;
END;
$$
LANGUAGE plpgsql

