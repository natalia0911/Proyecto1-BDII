--------------------------------------------------------
-- Archivo creado  - sábado-abril-17-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure SP_INSERTAUCTION
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_INSERTAUCTION" (
       pUsuarioId IN SUBASTA.ID%TYPE,
       pSubCatId IN SUBASTA.SUBCATEGORIAID%TYPE,
       pPrecioInicial IN SUBASTA.PRECIOINICIAL%TYPE,
       pDetalle IN SUBASTA.DETALLESENTREGA%TYPE,
       pFechaInicio IN SUBASTA.FECHAINICIO%TYPE,
       pFechaFin IN SUBASTA.FECHAFIN%TYPE)
IS
BEGIN

  INSERT INTO SUBASTA 
  (
        "USUARIOID"
       ,"SUBCATEGORIAID"
       ,"PRECIOINICIAL"
       ,"PRECIOFINAL"
       ,"DETALLESENTREGA"
       ,"FECHAINICIO"
       ,"FECHAFIN"
       ,"ACTIVA"
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
       ,1                        --Empieza estando activa
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_INSERTHISTOCOMP
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_INSERTHISTOCOMP" (
    pIdComprador in historialvendedor.idcomprador%TYPE,
    pIdVendedor in historialvendedor.idvendedor%TYPE,
    pIdSubasta in historialvendedor.idsubasta%TYPE
    )
IS
BEGIN

  INSERT INTO HISTORIALCOMPRADOR 
  (
       IDCOMPRADOR,
       IDVENDEDOR,
       IDSUBASTA,
       CALIFICACION
  ) 
  VALUES 
  (
        pIdComprador,
        pIdVendedor,
        pIdSubasta,
        5        --Empieza estando activa
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_INSERTHISTOVEND
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_INSERTHISTOVEND" (
    pIdVendedor in historialvendedor.idvendedor%TYPE,
    pIdComprador in historialvendedor.idcomprador%TYPE,
    pIdSubasta in historialvendedor.idsubasta%TYPE
    )
IS
BEGIN

  INSERT INTO HISTORIALVENDEDOR 
  (
       IDVENDEDOR,
       IDCOMPRADOR,
       IDSUBASTA,
       CALIFICACION
  ) 
  VALUES 
  (
        pIdVendedor,
        pIdComprador,
        pIdSubasta,
        5        --Empieza estando activa
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_INSERTIMAGE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_INSERTIMAGE" (
       pIMAGE IN IMAGENES.IMAGEN%TYPE)
IS
BEGIN

  INSERT INTO IMAGENES 
  (
        "IMAGENID",
        "IMAGEN"

  ) 
  VALUES 
  (
        (SELECT MAX(ID) FROM SUBASTA)
       ,pIMAGE
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_INSERTPUJA
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_INSERTPUJA" (
       pCompradorID IN pujas.compradorid%TYPE,
       pSubastaID IN pujas.subastaid%TYPE,
       pPrecio IN PUJAS.PRECIO%TYPE)
IS
BEGIN

  INSERT INTO PUJAS 
  (
       "COMPRADORID"
       ,"SUBASTAID"
       ,"PRECIO"
       ,"FECHA"
  ) 
  VALUES 
  (
        pCompradorID
       ,pSubastaID
       ,pPrecio
       ,SYSDATE
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_INSERTUSER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_INSERTUSER" (
       pNombre IN USUARIO.NOMBRE%TYPE,
       pCedula IN USUARIO.CEDULA%TYPE,
       pDireccion IN USUARIO.DIRECCION%TYPE,
       pCorreo IN USUARIO.CORREO%TYPE,
       pEsAdmin IN USUARIO.ESADMIN%TYPE,
       pAlias IN USUARIO.ALIAS%TYPE,
       pContrasennia IN USUARIO.CONTRASENNIA%TYPE)
IS
BEGIN

  INSERT INTO USUARIO 
  (
        "NOMBRE"
       ,"CEDULA"
       ,"DIRECCION"
       ,"CORREO"
       ,"ESADMIN"
       ,"ALIAS"
       ,"CONTRASENNIA"
  ) 
  VALUES 
  (
        pNombre
       ,pCedula
       ,pDireccion
       ,pCorreo
       ,pEsAdmin
       ,pAlias
       ,pContrasennia
  );

  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_JOBENDAUCTION
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_JOBENDAUCTION" 
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
        SELECT S.IDGANADOR, S.USUARIOID, S.ID, 5
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 0;


    INSERT INTO HISTORIALVENDEDOR
    (
        IDVENDEDOR,
        IDCOMPRADOR,
        IDSUBASTA,
        CALIFICACION
    )

        SELECT S.USUARIOID, S.IDGANADOR, S.ID, 5
        FROM SUBASTA S
        WHERE FECHAFIN <= SYSDATE and S.ACTIVA = 0;

    UPDATE SUBASTA S

    SET     ACTIVA = 1

    WHERE FECHAFIN <= SYSDATE;


  COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTALLUSERS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTALLUSERS" (
       cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        "ID"
       ,"NOMBRE"
       ,"CEDULA"
       ,"DIRECCION"
       ,"CORREO"
       ,"ESADMIN"
       ,"ALIAS"
       ,"CONTRASENNIA"
    FROM USUARIO U;
COMMIT;
END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTAUCTION
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTAUCTION" (
       pSubCat IN SUBASTA.SUBCATEGORIAID%TYPE,
       cursor OUT SYS_REFCURSOR)

IS
BEGIN
     OPEN cursor FOR
     SELECT 
        S."ID"
       ,S."USUARIOID"
       ,U."NOMBRE"
       ,S."SUBCATEGORIAID"
       ,C."NOMBRE"
       ,S."PRECIOINICIAL"
       ,S."PRECIOFINAL"
       ,S."DETALLESENTREGA"
       ,S."FECHAINICIO"
       ,S."FECHAFIN"

    FROM SUBASTA S INNER JOIN SUBCATEGORIA C ON S.SUBCATEGORIAID = C.ID
    INNER JOIN USUARIO U ON S.USUARIOID = U.ID

    WHERE S.ACTIVA = 1 and S.SUBCATEGORIAID = pSubCat
    ORDER BY S.FECHAINICIO ASC;

COMMIT;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTCATEGORIES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTCATEGORIES" (
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
--------------------------------------------------------
--  DDL for Procedure SP_SELECTHISTORIALCOMPRADOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTHISTORIALCOMPRADOR" (
       pcompradorId IN HISTORIALVENDEDOR.IDCOMPRADOR%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        HC."IDCOMPRADOR"
       ,UV."NOMBRE"
       ,HC."IDVENDEDOR"
       ,UC."NOMBRE"
       ,HC."IDSUBASTA"
       ,S."PRECIOINICIAL"
       ,S."PRECIOFINAL"
       ,HC."COMENTARIO"
       ,HC."CALIFICACION"
       ,S.FECHAFIN

   FROM HISTORIALCOMPRADOR HC INNER JOIN USUARIO UV ON HC.IDVENDEDOR = UV.ID 
   INNER JOIN USUARIO UC ON HC.IDCOMPRADOR = UC.ID
   INNER JOIN SUBASTA S ON HC.IDSUBASTA = S.ID

   WHERE HC.IDCOMPRADOR = pcompradorId;

COMMIT;
END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTHISTORIALVENDEDOR
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTHISTORIALVENDEDOR" (
       pVendedorId IN HISTORIALVENDEDOR.IDVENDEDOR%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        HV."IDVENDEDOR"
       ,UV."NOMBRE"
       ,HV."IDCOMPRADOR"
       ,UC."NOMBRE"
       ,HV."IDSUBASTA"
       ,S."PRECIOINICIAL"
       ,S."PRECIOFINAL"
       ,HV."COMENTARIO"
       ,HV."CALIFICACION"
       ,S.FECHAFIN

   FROM HISTORIALVENDEDOR HV INNER JOIN USUARIO UV ON HV.IDVENDEDOR = UV.ID 
   INNER JOIN USUARIO UC ON HV.IDCOMPRADOR = UC.ID
   INNER JOIN SUBASTA S ON HV.IDSUBASTA = S.ID

   WHERE HV.IDVENDEDOR = pVendedorId;

COMMIT;
END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTMIHISTOCOMP
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTMIHISTOCOMP" (
       miID IN HISTORIALVENDEDOR.IDCOMPRADOR%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        HC."IDCOMPRADOR"
       ,UV."NOMBRE"
       ,HC."IDVENDEDOR"
       ,UC."NOMBRE"
       ,HC."IDSUBASTA"
       ,S."PRECIOINICIAL"
       ,S."PRECIOFINAL"
       ,HC."COMENTARIO"
       ,HC."CALIFICACION"
       ,S.FECHAFIN

   FROM HISTORIALCOMPRADOR HC INNER JOIN USUARIO UV ON HC.IDCOMPRADOR = UV.ID 
   INNER JOIN USUARIO UC ON HC.IDCOMPRADOR = UC.ID
   INNER JOIN SUBASTA S ON HC.IDSUBASTA = S.ID

   WHERE HC.IDVENDEDOR = miID;

COMMIT;
END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTMIHISTOVEND
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTMIHISTOVEND" (
       miID IN HISTORIALVENDEDOR.IDVENDEDOR%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        HV."IDVENDEDOR"
       ,UV."NOMBRE"
       ,HV."IDCOMPRADOR"
       ,UC."NOMBRE"
       ,HV."IDSUBASTA"
       ,S."PRECIOINICIAL"
       ,S."PRECIOFINAL"
       ,HV."COMENTARIO"
       ,HV."CALIFICACION"
       ,S.FECHAFIN

   FROM HISTORIALVENDEDOR HV INNER JOIN USUARIO UV ON HV.IDVENDEDOR = UV.ID 
   INNER JOIN USUARIO UC ON HV.IDCOMPRADOR = UC.ID
   INNER JOIN SUBASTA S ON HV.IDSUBASTA = S.ID

   WHERE HV.IDCOMPRADOR = miID;

COMMIT;
END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTPARAMETERS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTPARAMETERS" (
       cursor OUT SYS_REFCURSOR)
IS
BEGIN
     OPEN cursor FOR
     SELECT 
        "CODPARAMETER"
       ,"VALOR"
    FROM SYSTEMPARAMETERS;
COMMIT;
END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTPUJAS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTPUJAS" (
       pSubastaId IN PUJAS.SUBASTAID%TYPE,
       cursor OUT SYS_REFCURSOR)
       
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        P."ID"
       ,P."COMPRADORID"
       ,U."ALIAS"
       ,P."SUBASTAID"
       ,P."PRECIO"
       ,P."FECHA"

   FROM PUJAS P INNER JOIN USUARIO U ON P.COMPRADORID = U.ID
   WHERE P.SUBASTAID = pSubastaId
   ORDER BY P.PRECIO DESC;

COMMIT;


END;

/
--------------------------------------------------------
--  DDL for Procedure SP_SELECTSUBCATEGORIES
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTSUBCATEGORIES" (
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
--------------------------------------------------------
--  DDL for Procedure SP_SELECTUSERS
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_SELECTUSERS" (
       pAlias IN USUARIO.ALIAS%TYPE,
       pContrasennia IN USUARIO.CONTRASENNIA%TYPE,
       cursor OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursor FOR
    SELECT 
        "ID"
       ,"NOMBRE"
       ,"CEDULA"
       ,"DIRECCION"
       ,"CORREO"
       ,"ESADMIN"
       ,"ALIAS"
       ,"CONTRASENNIA"
    FROM USUARIO U
    WHERE U.ALIAS = pAlias AND U.CONTRASENNIA = pContrasennia;
COMMIT;
END;

/

  GRANT EXECUTE ON "NATALIA"."SP_SELECTUSERS" TO "CLIENTE";
--------------------------------------------------------
--  DDL for Procedure SP_UPDATEAUCTION
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_UPDATEAUCTION" (
       pId IN SUBASTA.ID%TYPE,
       pPrecioFinal IN SUBASTA.PRECIOFINAL%TYPE)
IS
BEGIN
    UPDATE SUBASTA 
    SET
            PRECIOFINAL = pPrecioFinal
           ,ACTIVA = 0
    WHERE ID = pId;
COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
--------------------------------------------------------
--  DDL for Procedure SP_UPDATEUSER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE NONEDITIONABLE PROCEDURE "NATALIA"."SP_UPDATEUSER" (
       pNombre IN USUARIO.NOMBRE%TYPE,
       pCedula IN USUARIO.CEDULA%TYPE,
       pDireccion IN USUARIO.DIRECCION%TYPE,
       pCorreo IN USUARIO.CORREO%TYPE,
       pAlias IN USUARIO.ALIAS%TYPE,
       pContrasennia IN USUARIO.CONTRASENNIA%TYPE,
       cursor OUT SYS_REFCURSOR)
IS
BEGIN
    UPDATE USUARIO 
    SET
            NOMBRE = pNombre
           ,DIRECCION = pDireccion
           ,CORREO = pCorreo
           ,ALIAS = pAlias
           ,CONTRASENNIA = pContrasennia
    WHERE CEDULA = pCedula;
COMMIT;
EXCEPTION
   WHEN OTHERS THEN
   ROLLBACK;

END;

/
