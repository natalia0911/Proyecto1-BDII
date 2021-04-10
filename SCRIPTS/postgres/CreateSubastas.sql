-- Table: public.subastas

-- DROP TABLE public.subastas;

CREATE TABLE public.subastas
(
    "ID" numeric(20,0) NOT NULL,
    "usuarioID" numeric(20,0) NOT NULL,
    foto character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "precioInicial" numeric(20,0) NOT NULL,
    "precioFinal" numeric(20,0) NOT NULL,
    "DetallesEntrega" character varying(256) COLLATE pg_catalog."default" NOT NULL,
    "FechaInicio" date NOT NULL,
    "FechaFin" date NOT NULL,
    "Subcategoria" integer NOT NULL DEFAULT nextval('"subastas_Subcategoria_seq"'::regclass),
    CONSTRAINT subastas_pkey PRIMARY KEY ("ID"),
    CONSTRAINT "Subcategoria" FOREIGN KEY ("Subcategoria")
        REFERENCES public."Subcategorias" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT "UsuarioID" FOREIGN KEY ("usuarioID")
        REFERENCES public."Usuarios" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE public.subastas
    OWNER to postgres;