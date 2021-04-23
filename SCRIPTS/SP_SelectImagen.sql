

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 21/03/2021
--- Descripci�n: Inserta una nueva subasta(auction)
--------------------------------------------------------------------------

create or replace NONEDITIONABLE PROCEDURE SP_SelectImagen(
       pSubastaId IN imagenes.imagenid%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT I.IMAGEN
    FROM IMAGENES I
    WHERE I.IMAGENID = pSubastaID;

   Commit;

END;
/
