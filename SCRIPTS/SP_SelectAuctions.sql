


-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Inserta una nueva subasta(auction)
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_SelectAuction(
       pSubCat IN SUBCATEGORIA.NOMBRE%TYPE,
       pCateg IN CATEGORIA.NOMBRE%TYPE)

IS
BEGIN

   SELECT 
        "USUARIOID"
       ,"SUBCATEGORIAID"
       ,"FOTOITEM"
       ,"PRECIOINICIAL"
       ,"PRECIOFINAL"
       ,"DETALLESENTREGA"
       ,"FECHAINICIO"
       ,"FECHAFIN"

  FROM SUBASTA S INNER JOIN SUBCATEGORIA SC ON S.SUBCATEGORIAID = SC.ID AND SC.NOMBRE = pSubCat
  INNER JOIN CATEGORIA C ON SC.CATEGORIAID =  C.ID AND C.NOMBRE = pCateg
  
  WHERE S.ACTIVA = 1
  ORDER BY S.FECHAINICIO DESC;
  
COMMIT;


END;
/
