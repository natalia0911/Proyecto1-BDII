

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Inserta un nuevo usuario
--------------------------------------------------------------------------

CREATE FUNCTION SP_InsertUser(
       pNombre character varying(128),
       pCedula INT,
       pDireccion character varying(128),
       pCorreo character varying(128),
       pEsAdmin boolean,
       pAlias character varying(20),
       pContrasennia character varying(16)) returns void
AS $$
BEGIN
  INSERT INTO public."Usuario" 
  (
        "Nombre"
       ,"Cedula"
       ,"Direccion"
       ,"Correo"
       ,"EsAdmin"
       ,"Alias"
       ,"contraseña"
  ) 
  VALUES 
  (
        pNombre
       ,pCedula
       ,pDireccion
       ,pCorreo
       ,pEsAdmin
       ,pAlias
       ,pContrasennia
  );


--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 