
-------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creación: 30/03/2021
--- Descripción: Devolver todas las categorias
--------------------------------------------------------------------------
create or replace PROCEDURE SP_SelectCategories (
       cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        "ID"
       ,"NOMBRE"

    FROM CATEGORIA;
COMMIT;
END;
/