
CREATE OR REPLACE FUNCTION TR_FUNCTION() returns TRIGGER
AS $$
DECLARE PRECIOMEJORFINAL double precision;
BEGIN 
     SELECT S."PrecioFinal" INTO PRECIOMEJORFINAL FROM public."Subasta" AS S WHERE S."ID" = NEW."SubastaId";
	 IF NEW."Precio">PRECIOMEJORFINAL THEN
        UPDATE public."Subasta" AS SB 
        SET
            "PrecioFinal" = NEW."Precio"
           ,"IdGanador" = NEW."CompradorId"
        WHERE SB."ID" = NEW."SubastaId";
    END IF;
	RETURN NEW;
END;
$$
LANGUAGE plpgsql



---------------------------------
CREATE TRIGGER TR_UpdateBeforeInsertPujas
BEFORE INSERT ON public."Pujas" FOR EACH ROW
EXECUTE FUNCTION TR_FUNCTION();