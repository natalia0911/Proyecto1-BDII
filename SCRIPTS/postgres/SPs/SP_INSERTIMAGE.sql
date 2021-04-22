
---------------------------------------------------------------------------------------------------------
--- Creado por: Gustavo
--- Fecha creación: 14/04/2021
--- Descripción: Insertar Imagen
----------------------------------------------------------------------------------------------------------


CREATE FUNCTION SP_INSERTIMAGE(
       pIMAGE bytea) returns void
AS $$
BEGIN 
  INSERT INTO public."imagenes" 
  (
    "imagenid",
    "imagen"

  ) 
  VALUES 
  (
       (SELECT MAX("ID") FROM public."Subasta")
       ,pIMAGE
  );

--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 



