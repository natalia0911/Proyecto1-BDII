
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 21/03/2021
--- Descripci�n: Listar subastas
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SelectAuction(
       pSubCat IN SUBASTA.SUBCATEGORIAID%TYPE,
       cursor OUT SYS_REFCURSOR)

IS
BEGIN
     OPEN cursor FOR
     SELECT 
        "ID"
       ,"USUARIOID"
       ,"SUBCATEGORIAID"
       ,"PRECIOINICIAL"
       ,"PRECIOFINAL"
       ,"DETALLESENTREGA"
       ,"FECHAINICIO"
       ,"FECHAFIN"

    FROM SUBASTA S
    WHERE S.ACTIVA = 1
    ORDER BY S.FECHAINICIO DESC;
  
COMMIT;
END;
/
