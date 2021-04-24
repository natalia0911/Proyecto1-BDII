
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 21/03/2021
--- Descripción: Inserta una nueva subasta(auction)
--------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION SP_InsertAuction(
       pUsuarioId INT,
       pSubCatId INT,
       pPrecioInicial double precision,
       pDetalle character varying,
       pFechaInicio DATE,
       pFechaFin DATE) returns void
AS $$
BEGIN 
  INSERT INTO public."Subasta" 
  (
	"UsuarioId", 
	"SubCategoriaId",
	"PrecioInicial", 
	"PrecioFinal", 
    "DetallesEntrega", 
	"FechaInicio", 
	"FechaFin", 
	"Activa"
  ) 
  VALUES 
  (
        pUsuarioId
       ,pSubCatId
       ,pPrecioInicial
       ,0                        --PrecioFinal aun no se sabe
       ,pDetalle
       ,pFechaInicio
       ,pFechaFin
       ,TRUE                 --Empieza estando activa
  );

END;
$$
LANGUAGE plpgsql 


