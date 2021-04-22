
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Actualiza un usuario
--------------------------------------------------------------------------

CREATE FUNCTION SP_UpdateUser(
       pNombre character varying(128),
       pCedula INT,
       pDireccion character varying(128),
       pCorreo character varying(128),
       pAlias character varying(20),
       pContrasennia character varying(16)) returns void
AS $$
BEGIN 
    UPDATE public."Usuario" AS U
    SET
            "Nombre" = pNombre
           ,"Direccion" = pDireccion
           ,"Correo" = pCorreo
           ,"Alias" = pAlias
           ,"contraseña" = pContrasennia
    WHERE U."Cedula" = pCedula;

--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 