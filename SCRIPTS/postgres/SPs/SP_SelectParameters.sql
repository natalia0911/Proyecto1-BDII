
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 05/04/2021
--- Descripción: Listar parametros
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SelectParameters()
LANGUAGE SQL
AS $$
     SELECT 
        "CodParameter"
       ,"Valor"
    FROM public."SystemParameters";
$$;
  COMMIT;
END;
