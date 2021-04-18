-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar las pujas de una determinada subasta 
--------------------------------------------------------------------------

CREATE PROCEDURE SP_SelectPujas(
       pSubastaId INT		   )
       
LANGUAGE SQL
AS $$
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

$$;
COMMIT;
END;

