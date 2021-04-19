
--VER TABLAS
SELECT * FROM categoria;
SELECT * FROM Subcategoria order by ID;
SELECT * FROM USUARIO;
SELECT * FROM Telefono;
SELECT * FROM Subasta order by ID;
update subasta
set activa = 1
where activa = 0

--Para tomar la fecha y hora
select to_char(S.FECHAINICIO, 'mm/dd/yyyy hh24:mi:ss') from Subasta S;
select to_char(s.fechafin, 'mm/dd/yyyy hh24:mi:ss') from Subasta S;
SELECT * FROM Pujas;
SELECT * FROM HistorialComprador;
SELECT * FROM HistorialVendedor;
SELECT * FROM IMAGENES;
SELECT * FROM SYSTEMPARAMETERS;
SELECT * FROM PRUEBA;

--//////////////////ELIMINAR TABLAS/////////////////////////
DROP TABLE HistorialVendedor;
DROP TABLE HistorialComprador;
DROP TABLE Pujas;
DROP TABLE Subasta;
DROP TABLE Telefono;
DROP TABLE Usuario;
DROP TABLE SubCategoria;
DROP TABLE Categoria;
--//////////////////ELIMINAR TABLAS/////////////////////////

--Reiniciar identities y borrar datos
DELETE FROM USUARIO;
ALTER TABLE USUARIO MODIFY(ID GENERATED AS IDENTITY (START WITH 1));

DELETE FROM Telefono;
ALTER TABLE Telefono MODIFY(ID GENERATED AS IDENTITY (START WITH 1));

DELETE FROM SubCategoria;
ALTER TABLE SubCategoria MODIFY(ID GENERATED AS IDENTITY (START WITH 1));

DELETE FROM Categoria;
ALTER TABLE Categoria MODIFY(ID GENERATED AS IDENTITY (START WITH 1));

DELETE FROM Pujas;
ALTER TABLE Pujas MODIFY(ID GENERATED AS IDENTITY (START WITH 1));

DELETE FROM Subasta;
ALTER TABLE Subasta MODIFY(ID GENERATED AS IDENTITY (START WITH 1));

DELETE FROM HistorialComprador;
ALTER TABLE HistorialComprador MODIFY(ID GENERATED AS IDENTITY (START WITH 1));

DELETE FROM HistorialVendedor;
ALTER TABLE HistorialVendedor MODIFY(ID GENERATED AS IDENTITY (START WITH 1));


--Cambiar campo a permitir null
alter table Subasta modify FOTOITEM null;
alter table HISTORIALCOMPRADOR modify COMENTARIO null;
alter table HISTORIALVENDEDOR modify COMENTARIO null;

alter table Subasta add IDGANADOR DECIMAL NULL;
alter table Subasta
  add constraint ID_USUARIO_POSTOR_FK
  foreign key (IDGANADOR)
  REFERENCES USUARIO(Id);
  
--Borrar campo de tabla
alter table Subasta drop column FOTOITEM;
alter table Subasta drop column compradorId;

ALTER TABLE Subasta DROP CONSTRAINT ID_USUARIO_POSTOR_FK


--Insertar datos prueba
---Subastas
INSERT INTO SUBASTA (USUARIOID,SUBCATEGORIAID,PRECIOINICIAL,PRECIOFINAL,DETALLESENTREGA,FECHAINICIO,FECHAFIN,ACTIVA) 
VALUES(4,1,5000,0,'Se entrega en el parque',TO_DATE('02-07-2021 12:01','DD-MM-YYYY HH:MI'),TO_DATE('06-07-2021 12:50','DD-MM-YYYY HH:MI'),1);
--Pujas
INSERT INTO PUJAS (COMPRADORID,SUBASTAID,PRECIO,FECHA) VALUES(6,2,7000,TO_DATE('06-07-2021 07:50','DD-MM-YYYY HH:MI'));

INSERT INTO PUJAS (COMPRADORID,SUBASTAID,PRECIO,FECHA) VALUES(6,2,22000,TO_DATE('15-04-2021 07:50','DD-MM-YYYY HH:MI'));
INSERT INTO PUJAS (COMPRADORID,SUBASTAID,PRECIO,FECHA) VALUES(6,2,23000,TO_DATE('15-04-2021 07:50','DD-MM-YYYY HH:MI'));




