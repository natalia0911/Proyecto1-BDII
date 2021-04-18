

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 25/04/2021
--- Descripción: Actualiza parametros del sistema
--------------------------------------------------------------------------

CREATE PROCEDURE SP_UpdateParameters(
       pCodParameter character varying(128) ,
       pNewValue float)

LANGUAGE SQL
AS $$
    UPDATE public."SystemParameters" AS SP
    SET
        "Valor" = pNewValue
    WHERE SP."CodParameter" = pCodParameter;

$$;
  COMMIT;
--  END;
--	  EXCEPTION WHEN OTHERS THEN
--  	   ROLLBACK;

END;