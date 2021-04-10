-- Table: public.Categorias

-- DROP TABLE public."Categorias";

CREATE TABLE public."Categorias"
(
    "ID" integer NOT NULL DEFAULT nextval('"Categorias_ID_seq"'::regclass),
    "Nombre" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Categorias_pkey" PRIMARY KEY ("ID")
)

TABLESPACE pg_default;

ALTER TABLE public."Categorias"
    OWNER to postgres;