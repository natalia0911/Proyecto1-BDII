
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 25/04/2021
--- Descripción: Actualiza parametros del sistema
--------------------------------------------------------------------------

CREATE FUNCTION SP_UpdateParameters(
       pCodParameter character varying(128) ,
       pNewValue float) returns void

AS $$
BEGIN 
    UPDATE public."SystemParameters" AS SP
    SET
        "Valor" = pNewValue
    WHERE SP."CodParameter" = pCodParameter;

--COMMIT;
EXCEPTION WHEN OTHERS THEN
	ROLLBACK;

END;
$$
LANGUAGE plpgsql 
