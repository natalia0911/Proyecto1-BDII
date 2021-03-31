

-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 30/03/2021
--- Descripción: Devolver todas las subcategorias de una categoria dada
--------------------------------------------------------------------------
create or replace PROCEDURE SP_SelectSubcategories (
       pCategoriaId IN SUBCATEGORIA.CATEGORIAID%TYPE,
       cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        "ID"
       ,"NOMBRE"

    FROM SUBCATEGORIA S
    WHERE S.CATEGORIAID = pCategoriaId;
COMMIT;
END;
/