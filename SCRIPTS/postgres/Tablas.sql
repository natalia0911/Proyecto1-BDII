CREATE TABLE public."Categoria" (
    "Id" INT PRIMARY KEY NOT NULL,
    "Nombre" character varying(128) NOT NULL
)

CREATE TABLE "SubCategoria" (
    "Id" INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
    "Nombre" character varying(128) NOT NULL,
    "CategoriaId" INT NOT NULL
	--FK CON CATEGORIA
)


CREATE TABLE public."Usuario"
(
    "Id" INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
    "Nombre" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "Cedula" int NOT NULL,
    "Direccion" character varying(128) COLLATE pg_catalog."default" NOT NULL,
	"Correo" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "EsAdmin" boolean NOT NULL,
	"Alias" character varying(20),
    "contraseña" character varying(16) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Cedula" UNIQUE ("Cedula"),
    CONSTRAINT "Id" UNIQUE ("Id")
)


CREATE TABLE public."Telefono"(
    "Id" INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
    "Numero" INT NOT NULL,
    "Usuario" INT NOT NULL
   -- CONSTRAINT "ID_USUARIO_FK" FOREIGN KEY ("Usuario") REFERENCES Usuario("ID")
)


CREATE TABLE public."Subasta"(
    "ID" INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
    "UsuarioId" INT NOT NULL,
    "GanadorId" INT NOT NULL,
    "SubCategoriaId" INT NOT NULL,
    "FotoItem" character varying(128),
    "PrecioInicial" NUMERIC NOT NULL,
    "PrecioFinal" NUMERIC NOT NULL,
    "DetallesEntrega" character varying(128) NOT NULL,
    "FechaInicio" DATE NOT NULL,
    "FechaFin" DATE NOT NULL,
    "Activa" boolean NOT NULL
   -- CONSTRAINT ID_USUARIO_VENDEDOR_FK FOREIGN KEY (UsuarioId) REFERENCES Usuario(Id),
   -- CONSTRAINT ID_SUBCATEGORIA_FK FOREIGN KEY (SubCategoriaId) REFERENCES SubCategoria(Id),
   -- CONSTRAINT ID_USUARIO_VENDEDOR_FK FOREIGN KEY (compradorId)REFERENCES USUARIO(Id)
)



CREATE TABLE public."Pujas" (
    "Id" INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY NOT NULL,
    "CompradorId" INT NOT NULL,
    "SubastaId" INT NOT NULL,
    "Precio" INT NOT NULL,
    "Fecha" DATE NOT NULL
    --CONSTRAINT ID_USUARIO_COMPRADOR_FK FOREIGN KEY (CompradorId) REFERENCES Usuario(Id),
    --CONSTRAINT ID_SUBASTA_FK FOREIGN KEY (SubastaId) REFERENCES Subasta(Id)
)



CREATE TABLE public."HistorialComprador" (
    "IdComprador" INT NOT NULL,
    "IdVendedor" INT NOT NULL,
    "IdSubasta" INT NOT NULL,
    "Comentario" character varying(128) NOT NULL,
    "Calificacion" INT NOT NULL
   -- CONSTRAINT ID_USUARIO_COMPARDOR_EN_HISTCOMPRADOR_FK FOREIGN KEY (IdComprador) REFERENCES Usuario(Id),
   -- CONSTRAINT ID_USUARIO_VENDEDOR_EN_HISTCOMPRADOR_FK FOREIGN KEY (IdVendedor) REFERENCES Usuario(Id),
   -- CONSTRAINT ID_SUBASTA_EN_HISTCOMPRADOR_FK FOREIGN KEY (IdSubasta) REFERENCES Subasta(Id)
)



CREATE TABLE public."HistorialVendedor" (
    "IdVendedor" INT NOT NULL,
    "IdComprador" INT NOT NULL,
    "IdSubasta" INT NOT NULL,
    "Comentario" character varying(128) NOT NULL,
    "Calificacion" INT NOT NULL
   -- CONSTRAINT ID_USUARIO_VENDEDOR_EN_HISTVENDEDOR_FK FOREIGN KEY (IdVendedor) REFERENCES Usuario(Id),
   -- CONSTRAINT ID_USUARIO_COMPARDOR_EN_HISTVENDEDOR_FK FOREIGN KEY (IdComprador) REFERENCES Usuario(Id),
   -- CONSTRAINT ID_SUBASTA_EN_HISTVENDEDOR_FK FOREIGN KEY (IdSubasta) REFERENCES Subasta(Id)
)


CREATE TABLE IMAGENES(
    ImagenId INT,
    Imagen bytea
    --CONSTRAINT SUBASTAID_FK FOREIGN KEY (IMAGENID) REFERENCES Subasta(ID)
)


CREATE TABLE public."SystemParameters"(
    "CodParameter" character varying(128) NOT NULL,
    "Valor" float NOT NULL
);

INSERT INTO "SystemParameters"("CodParameter","Valor") VALUES ('PERC',5);  --Percentage
INSERT INTO "SystemParameters"("CodParameter","Valor") VALUES ('MIN',5000);  --Minimum

