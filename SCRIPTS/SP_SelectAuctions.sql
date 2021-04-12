
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Listar subastas
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SelectAuction(
       pSubCat IN SUBASTA.SUBCATEGORIAID%TYPE,
       cursor OUT SYS_REFCURSOR)

IS
BEGIN
     OPEN cursor FOR
     SELECT 
        S."ID"
       ,S."USUARIOID"
       ,U."ALIAS"
       ,S."SUBCATEGORIAID"
       ,C."NOMBRE"
       ,S."PRECIOINICIAL"
       ,S."PRECIOFINAL"
       ,S."DETALLESENTREGA"
       ,S."FECHAINICIO"
       ,S."FECHAFIN"

    FROM SUBASTA S INNER JOIN SUBCATEGORIA C ON S.SUBCATEGORIAID = C.ID
    INNER JOIN USUARIO U ON S.USUARIOID = U.ID
    
    WHERE S.ACTIVA = 1 and S.SUBCATEGORIAID = pSubCat
    ORDER BY S.FECHAINICIO ASC;
  
COMMIT;
END;
/
