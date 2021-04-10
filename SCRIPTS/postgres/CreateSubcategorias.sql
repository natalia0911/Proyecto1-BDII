-- Table: public.Subcategorias

-- DROP TABLE public."Subcategorias";

CREATE TABLE public."Subcategorias"
(
    "ID" integer NOT NULL DEFAULT nextval('"Subcategorias_ID_seq"'::regclass),
    "Nombre" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "categoriaID" integer NOT NULL DEFAULT nextval('"Subcategorias_categoriaID_seq"'::regclass),
    CONSTRAINT "Subcategorias_pkey" PRIMARY KEY ("ID"),
    CONSTRAINT categoriaid FOREIGN KEY ("categoriaID")
        REFERENCES public.subastas ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public."Subcategorias"
    OWNER to postgres;