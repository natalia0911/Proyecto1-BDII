CREATE PROCEDURE SP_INSERTIMAGE(
       pIMAGE bytea)
LANGUAGE SQL
AS $$
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
$$;
  COMMIT;
--  END;
--	  EXCEPTION WHEN OTHERS THEN
--  	   ROLLBACK;

END;




