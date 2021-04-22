
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 05/04/2021
--- Descripción: Listar parametros
--------------------------------------------------------------------------

CREATE FUNCTION SP_SelectParameters()
	returns setof public."SystemParameters"
AS $$
BEGIN 
	RETURN QUERY
    SELECT 
        "CodParameter"
       ,"Valor"
    FROM public."SystemParameters";
END;
$$
LANGUAGE plpgsql