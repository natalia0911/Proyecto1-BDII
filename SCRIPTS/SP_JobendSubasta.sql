create or replace NONEDITIONABLE PROCEDURE SP_JobEndAuction
IS
BEGIN

    UPDATE SUBASTA S
    
    SET    IDGANADOR = (SELECT COMPRADORID FROM PUJAS P WHERE S.ID = p.subastaid and rownum = 1)
    
    WHERE FECHAFIN <= SYSDATE;

    INSERT INTO HISTORIALCOMPRADOR
    (
        IDCOMPRADOR,
        IDVENDEDOR,
        IDSUBASTA,
        CALIFICACION
    )
    VALUES
    (
        (SELECT S.IDGANADOR
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 0 and rownum = 1),
        (SELECT s.usuarioid
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 0 and rownum = 1),
        (SELECT S.ID
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 0 and rownum = 1),
        
        5
    );
    
    INSERT INTO HISTORIALVENDEDOR
    (
        IDVENDEDOR,
        IDCOMPRADOR,
        IDSUBASTA,
        CALIFICACION
    )
    VALUES
    (
        (SELECT s.usuarioid
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 0 and rownum = 1),
        (SELECT S.IDGANADOR
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 0 and rownum = 1),
        (SELECT S.ID
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 0 and rownum = 1),
        
        5
    );

    UPDATE SUBASTA S
    
    SET     ACTIVA = 1,
            IDGANADOR = (SELECT COMPRADORID FROM PUJAS P WHERE S.ID = p.subastaid and rownum = 1)
    
    WHERE FECHAFIN <= SYSDATE;


  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;