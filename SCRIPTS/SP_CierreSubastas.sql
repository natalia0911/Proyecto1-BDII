
SET SERVEROUTPUT ON;
DECLARE 
    maxId DECIMAL;
    minId DECIMAL;
    idS decimal :=-1;
    fechaCierre Date;
    i decimal;
BEGIN
    SELECT MAX(ID)INTO maxId FROM SUBASTA;
    SELECT MIN(ID)INTO minId FROM SUBASTA;

    
     WHILE ( minId <= maxId)
        Loop
            SELECT S.ID INTO ids from SUBASTA S WHERE S.ID = minId;
           -- SELECT S.FECHAFIN INTO fechaCierre from SUBASTA S WHERE S.ID = 1;
            IF ids >0
            THEN
                dbms_output.put_line(ids);
            END IF;
            
            
            if SYSDATE>=fechaCierre
            THEN
                dbms_output.put_line(minId);
            END IF;
            minId := minId + 1;
        END LOOP;
 
END;


--YA ESTOY HASTA LA MIERDAAAA DE ORACLE POR QUÉ NO ES TAN FACIL COMO MSSQL?????????????????????????

select * from subasta
SELECT S.FECHAFIN from SUBASTA S WHERE S.ID = 5;