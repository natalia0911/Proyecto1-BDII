
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Actualiza un usuario
--------------------------------------------------------------------------

CREATE PROCEDURE SP_UpdateUser(
       pNombre character varying(128),
       pCedula INT,
       pDireccion character varying(128),
       pCorreo character varying(128),
       pAlias character varying(20),
       pContrasennia character varying(16))
LANGUAGE SQL
AS $$
    UPDATE public."Usuario" AS U
    SET
            "Nombre" = pNombre
           ,"Direccion" = pDireccion
           ,"Correo" = pCorreo
           ,"Alias" = pAlias
           ,"contraseña" = pContrasennia
    WHERE U."Cedula" = pCedula;

$$;
COMMIT;
--  END;
--	  EXCEPTION WHEN OTHERS THEN
--  	   ROLLBACK;

END;