


-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 21/03/2021
--- Descripci�n: Listar subastas
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SelectAuctionById(
       pId IN SUBASTA.Id%TYPE,
       cursor OUT SYS_REFCURSOR)

IS
BEGIN
     OPEN cursor FOR
     SELECT 
        "ID"
       ,"USUARIOID"
       ,"SUBCATEGORIAID"
       ,"PRECIOINICIAL"

    FROM SUBASTA S 
    WHERE S.ID = pId;
  
COMMIT;
END;
/