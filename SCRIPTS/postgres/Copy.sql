
--select SP_InsertUser('natalíñüa',123457000,'pital','nata@gmail',true,'nata','nata');
--select * from public."Usuario" ;

--set client_encoding to 'UTF8';

COPY public."Categoria"
FROM 'D:\1 SEMESTRE 2021\BASES 2\PROYECTOS\Proyecto1-BDII\CSVs\Categorias.csv'		
WITH DELIMITER ';' 
CSV HEADER encoding 'windows-1258' 

--Necesito resetear el identity en 1
COPY public."SubCategoria" ("Nombre", "CategoriaId")
FROM 'D:\1 SEMESTRE 2021\BASES 2\PROYECTOS\Proyecto1-BDII\CSVs\Subcategorias.csv'		
WITH DELIMITER ';' 
CSV HEADER encoding 'windows-1258'

SELECT * FROM public."Categoria"
SELECT * FROM public."SubCategoria"

DELETE FROM public."Categoria"
DELETE FROM public."SubCategoria"

Insert


------------------------------INTENTO DE RESETEAR IDENTITY
ALTER TABLE public."SubCategoria" as s
    ALTER COLUMN s."Id"
        RESTART WITH 1;

TRUNCATE TABLE public."SubCategoria" RESTART IDENTITY;
TRUNCATE TABLE public."Subasta" RESTART IDENTITY;
TRUNCATE TABLE public."Pujas" RESTART IDENTITY;