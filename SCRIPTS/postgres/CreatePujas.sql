-- Table: public.pujas

-- DROP TABLE public.pujas;

CREATE TABLE public.pujas
(
    "ID" integer NOT NULL DEFAULT nextval('"pujas_ID_seq"'::regclass),
    "CompradorID" numeric(20,0) NOT NULL,
    "SubastaID" numeric(20,0) NOT NULL,
    "Precio" numeric(40,0) NOT NULL,
    "Fecha" date NOT NULL,
    CONSTRAINT pujas_pkey PRIMARY KEY ("ID"),
    CONSTRAINT "CompradorID" FOREIGN KEY ("CompradorID")
        REFERENCES public."Usuarios" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "SubastaID" FOREIGN KEY ("ID")
        REFERENCES public.subastas ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.pujas
    OWNER to postgres;