



-- Table: public.Categoria

-- DROP TABLE public."Categoria";

CREATE TABLE public."Categoria"
(
    "Id" integer NOT NULL,
    "Nombre" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Categoria_pkey" PRIMARY KEY ("Id")
)

TABLESPACE pg_default;

ALTER TABLE public."Categoria"
    OWNER to postgres;
	
	
	
	-- Table: public.SubCategoria

-- DROP TABLE public."SubCategoria";

CREATE TABLE public."SubCategoria"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Nombre" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "CategoriaId" integer NOT NULL,
    CONSTRAINT "SubCategoria_pkey" PRIMARY KEY ("Id"),
    CONSTRAINT "ID_CATEGORIA_PK" FOREIGN KEY ("CategoriaId")
        REFERENCES public."Categoria" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."SubCategoria"
    OWNER to postgres;
	
	
	
	
-- Table: public.Usuario

-- DROP TABLE public."Usuario";

CREATE TABLE public."Usuario"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Nombre" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "Cedula" integer NOT NULL,
    "Direccion" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "Correo" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "EsAdmin" boolean NOT NULL,
    "Alias" character varying(20) COLLATE pg_catalog."default",
    "contraseña" character varying(16) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Id" PRIMARY KEY ("Id"),
    CONSTRAINT "Cedula" UNIQUE ("Cedula")
)

TABLESPACE pg_default;

ALTER TABLE public."Usuario"
    OWNER to postgres;
	
	
	


-- Table: public.Telefono

-- DROP TABLE public."Telefono";

CREATE TABLE public."Telefono"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "Numero" integer NOT NULL,
    "Usuario" integer NOT NULL,
    CONSTRAINT "Telefono_pkey" PRIMARY KEY ("Id"),
    CONSTRAINT "ID_USUARIO_FK" FOREIGN KEY ("Usuario")
        REFERENCES public."Usuario" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."Telefono"
    OWNER to postgres;
	
	
	
	
-- Table: public.Subasta

-- DROP TABLE public."Subasta";

CREATE TABLE public."Subasta"
(
    "ID" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "UsuarioId" integer NOT NULL,
    "IdGanador" integer,
    "SubCategoriaId" integer NOT NULL,
    "PrecioInicial" double precision NOT NULL,
    "PrecioFinal" double precision NOT NULL,
    "DetallesEntrega" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "FechaInicio" date NOT NULL,
    "FechaFin" date NOT NULL,
    "Activa" boolean NOT NULL,
    CONSTRAINT "Subasta_pkey" PRIMARY KEY ("ID"),
    CONSTRAINT "ID_SUBCATEGORIA_FK" FOREIGN KEY ("SubCategoriaId")
        REFERENCES public."SubCategoria" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "ID_USUARIO_COMPRADOR_FK" FOREIGN KEY ("IdGanador")
        REFERENCES public."Usuario" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "ID_USUARIO_VENDEDOR_FK" FOREIGN KEY ("UsuarioId")
        REFERENCES public."Usuario" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."Subasta"
    OWNER to postgres;
	
	
	
	
-- Table: public.Pujas

-- DROP TABLE public."Pujas";

CREATE TABLE public."Pujas"
(
    "Id" integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    "CompradorId" integer NOT NULL,
    "SubastaId" integer NOT NULL,
    "Precio" double precision NOT NULL,
    "Fecha" date NOT NULL,
    CONSTRAINT "Pujas_pkey" PRIMARY KEY ("Id"),
    CONSTRAINT "ID_SUBASTA_FK" FOREIGN KEY ("SubastaId")
        REFERENCES public."Subasta" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "ID_USUARIO_COMPRADOR_FK" FOREIGN KEY ("CompradorId")
        REFERENCES public."Usuario" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."Pujas"
    OWNER to postgres;

-- Trigger: tr_updatebeforeinsertpujas

-- DROP TRIGGER tr_updatebeforeinsertpujas ON public."Pujas";

CREATE TRIGGER tr_updatebeforeinsertpujas
    BEFORE INSERT
    ON public."Pujas"
    FOR EACH ROW
    EXECUTE PROCEDURE public.tr_function();
	
	
	
	
	
	-- Table: public.HistorialComprador

-- DROP TABLE public."HistorialComprador";

CREATE TABLE public."HistorialComprador"
(
    "IdComprador" integer NOT NULL,
    "IdVendedor" integer NOT NULL,
    "IdSubasta" integer NOT NULL,
    "Comentario" character varying(128) COLLATE pg_catalog."default",
    "Calificacion" integer NOT NULL,
    CONSTRAINT "ID_SUBASTA_EN_HISTCOMPRADOR_FK" FOREIGN KEY ("IdSubasta")
        REFERENCES public."Subasta" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "ID_USUARIO_COMPARDOR_EN_HISTCOMPRADOR_FK" FOREIGN KEY ("IdComprador")
        REFERENCES public."Usuario" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "ID_USUARIO_VENDEDOR_EN_HISTCOMPRADOR_FK" FOREIGN KEY ("IdVendedor")
        REFERENCES public."Usuario" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."HistorialComprador"
    OWNER to postgres;
	
	
	
	
-- Table: public.HistorialVendedor

-- DROP TABLE public."HistorialVendedor";

CREATE TABLE public."HistorialVendedor"
(
    "IdVendedor" integer NOT NULL,
    "IdComprador" integer NOT NULL,
    "IdSubasta" integer NOT NULL,
    "Comentario" character varying(128) COLLATE pg_catalog."default",
    "Calificacion" integer NOT NULL,
    CONSTRAINT "ID_SUBASTA_EN_HISTVENDEDOR_FK" FOREIGN KEY ("IdSubasta")
        REFERENCES public."Subasta" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "ID_USUARIO_COMPARDOR_EN_HISTVENDEDOR_FK" FOREIGN KEY ("IdComprador")
        REFERENCES public."Usuario" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "ID_USUARIO_VENDEDOR_EN_HISTVENDEDOR_FK" FOREIGN KEY ("IdVendedor")
        REFERENCES public."Usuario" ("Id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public."HistorialVendedor"
    OWNER to postgres;
	
	

	
	-- Table: public.imagenes

-- DROP TABLE public.imagenes;

CREATE TABLE public.imagenes
(
    imagenid integer,
    imagen bytea,
    CONSTRAINT "SUBASTAID_FK" FOREIGN KEY (imagenid)
        REFERENCES public."Subasta" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.imagenes
    OWNER to postgres;
	
	
	
	
-- Table: public.SystemParameters

-- DROP TABLE public."SystemParameters";

CREATE TABLE public."SystemParameters"
(
    "CodParameter" character varying(128) COLLATE pg_catalog."default" NOT NULL,
    "Valor" double precision NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE public."SystemParameters"
    OWNER to postgres;