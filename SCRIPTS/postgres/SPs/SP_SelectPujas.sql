-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar las pujas de una determinada subasta 
--------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION SP_SelectPujas(
    pSubastaId INT)
	returns table
	(
	 Id INT
    ,CompradorId INT
    ,Alias character varying(20)
    ,SubastaId INT
    ,Precio double precision
    ,Fecha DATE 
	)
AS $$
BEGIN 
	RETURN QUERY
    SELECT 
        P."Id"
       ,P."CompradorId"
       ,U."Alias"
       ,P."SubastaId"
       ,P."Precio"
       ,P."Fecha"

   FROM public."Pujas" AS P INNER JOIN public."Usuario" AS U ON P."CompradorId" = U."Id"
   WHERE P."SubastaId" = pSubastaId
   ORDER BY P."Precio" DESC;
END;
$$
LANGUAGE plpgsql
