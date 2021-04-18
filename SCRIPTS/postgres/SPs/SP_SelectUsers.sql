-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Devolver usuario que cumple con alias y contrasennia
--------------------------------------------------------------------------
create or replace PROCEDURE SP_SelectUsers (
       pAlias character varying(20),
       pContrasennia character varying(16) )
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
    FROM public."Usuario" AS U
    WHERE U."Alias" = pAlias AND U."contraseña" = pContrasennia;
$$;
  COMMIT;

END;