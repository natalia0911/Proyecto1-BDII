-- Table: public.Usuarios

-- DROP TABLE public."Usuarios";

CREATE TABLE public."Usuarios"
(
    "ID" numeric(20,0) NOT NULL,
    "Nombre" character varying(60) COLLATE pg_catalog."default" NOT NULL,
    "Cedula" numeric(9,0) NOT NULL,
    "Direccion" character varying(256) COLLATE pg_catalog."default" NOT NULL,
    "EsAdmin" boolean NOT NULL,
    "contraseña" character varying(16) COLLATE pg_catalog."default" NOT NULL,
    "Teléfono" numeric(8,0) NOT NULL,
    CONSTRAINT "Usuarios_pkey" PRIMARY KEY ("Cedula", "ID"),
    CONSTRAINT "Cedula" UNIQUE ("Cedula"),
    CONSTRAINT "ID" UNIQUE ("ID")
)

TABLESPACE pg_default;

ALTER TABLE public."Usuarios"
    OWNER to postgres;