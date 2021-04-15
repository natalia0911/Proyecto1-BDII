
--------------------------------------------------------------------------------------------
--- Creado por: Gustavo Orozco
--- Fecha creaci�n: 14/04/2021
--- Descripci�n: SP que ejecuta el job, cierra subastas que ya expiraron y asigna ganador
--------------------------------------------------------------------------------------------


create or replace NONEDITIONABLE PROCEDURE SP_JobEndAuction
IS
BEGIN

    UPDATE SUBASTA S

    SET   IDGANADOR = (SELECT IDGANADOR FROM (SELECT IDGANADOR FROM PUJAS P WHERE S.ID = p.subastaid  ORDER BY P.PRECIO DESC) WHERE rownum = 1)

    WHERE FECHAFIN <= SYSDATE;

    INSERT INTO HISTORIALCOMPRADOR
    (
        IDCOMPRADOR,
        IDVENDEDOR,
        IDSUBASTA,
        CALIFICACION
    )
        SELECT S.IDGANADOR, S.USUARIOID, S.ID, 5
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 1 and rownum = 1;


    INSERT INTO HISTORIALVENDEDOR
    (
        IDVENDEDOR,
        IDCOMPRADOR,
        IDSUBASTA,
        CALIFICACION
    )
        
        SELECT S.USUARIOID, S.IDGANADOR, S.ID, 5
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 1 and rownum = 1;

    UPDATE SUBASTA S

    SET     ACTIVA = 0

    WHERE FECHAFIN <= SYSDATE;


  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;