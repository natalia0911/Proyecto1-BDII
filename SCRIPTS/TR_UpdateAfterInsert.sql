
---------------------------------------------------------------------------------------------------------
--- Creado por: Natalia Vargas
--- Fecha creaci�n: 14/04/2021
--- Descripci�n: Disparador para actualizar la ganador y precio final de la subasta, con cada nueva puja
----------------------------------------------------------------------------------------------------------


CREATE OR REPLACE TRIGGER TR_UpdateBeforeInsertPujas
BEFORE INSERT ON PUJAS FOR EACH ROW

DECLARE PRECIOMEJORFINAL DECIMAL;
BEGIN
    
    SELECT S.PRECIOFINAL INTO PRECIOMEJORFINAL FROM SUBASTA S WHERE S.ID = :NEW.SUBASTAID;

    IF :NEW.PRECIO>PRECIOMEJORFINAL THEN
        UPDATE SUBASTA 
        SET
            PRECIOFINAL = :NEW.PRECIO
           ,IDGANADOR = :NEW.COMPRADORID
        WHERE ID = :NEW.SUBASTAID;
    END IF;
  

 END TR_UpdateBeforeInsertPujas;

