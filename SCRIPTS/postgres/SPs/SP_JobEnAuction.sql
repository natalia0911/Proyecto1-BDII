



--------------------------------------------------------------------------------------------
--- Creado por: Gustavo Orozco
--- Fecha creación: 14/04/2021
--- Descripción: SP que ejecuta el job, cierra subastas que ya expiraron y asigna ganador
--------------------------------------------------------------------------------------------


CREATE OR REPLACE FUNCTION SP_JobEndAuction() returns void
AS $$
BEGIN 
    INSERT INTO public."HistorialComprador"
    (
        "IdComprador",
        "IdVendedor",
        "IdSubasta",
        "Calificacion"
    )
        SELECT S."IdGanador", S."UsuarioId", S."ID", 5
        FROM "Subasta" AS S
        WHERE "FechaFin" <= now() and S."Activa" = TRUE and S."IdGanador" is not null;


    INSERT INTO public."HistorialVendedor"
    (
        "IdVendedor",
		"IdComprador",
        "IdSubasta",
        "Calificacion"
    )
        
        SELECT S."UsuarioId", S."IdGanador",  S."ID", 5
        FROM "Subasta" AS S
        WHERE  "FechaFin" <= now() and S."Activa" = TRUE and S."IdGanador" is not null;

    UPDATE public."Subasta" 

    SET  "Activa" = FALSE

    WHERE "FechaFin" <= now();


END;
$$
LANGUAGE plpgsql 
