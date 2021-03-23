

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Inserta una nueva subasta(auction)
--------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE SP_InsertAuction(
       pUsuarioId IN SUBASTA.ID%TYPE,
       pSubCatId IN SUBASTA.SUBCATEGORIAID%TYPE,
       pFoto IN SUBASTA.FOTOITEM%TYPE,
       pPrecioInicial IN SUBASTA.PRECIOINICIAL%TYPE,
       pDetalle IN SUBASTA.DETALLESENTREGA%TYPE,
       pFechaInicio IN SUBASTA.FECHAINICIO%TYPE,
       pFechaFin IN SUBASTA.FECHAFIN%TYPE)
IS
BEGIN

  INSERT INTO SUBASTA 
  (
        "USUARIOID"
       ,"SUBCATEGORIAID"
       ,"FOTOITEM"
       ,"PRECIOINICIAL"
       ,"PRECIOFINAL"
       ,"DETALLESENTREGA"
       ,"FECHAINICIO"
       ,"FECHAFIN"
       ,"ACTIVA"
  ) 
  VALUES 
  (
        pUsuarioId
       ,pSubCatId
       ,pFoto
       ,pPrecioInicial
       ,0                        --PrecioFinal aun no se sabe
       ,pDetalle
       ,pFechaInicio
       ,pFechaFin
       ,1                        --Empieza estando activa
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;
/
