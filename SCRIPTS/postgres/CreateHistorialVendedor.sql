-- Table: public.HistorialVendedor

-- DROP TABLE public."HistorialVendedor";

CREATE TABLE public."HistorialVendedor"
(
    "IDvendedor" numeric(20,0) NOT NULL,
    "IDComprador" numeric(20,0) NOT NULL,
    calificacion numeric(1,0) NOT NULL,
    comentario character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT "HistorialVendedor_pkey" PRIMARY KEY ("IDvendedor", "IDComprador"),
    CONSTRAINT "IDcomprador" FOREIGN KEY ("IDComprador")
        REFERENCES public."Usuarios" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "IDvendedor" FOREIGN KEY ("IDvendedor")
        REFERENCES public."Usuarios" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public."HistorialVendedor"
    OWNER to postgres;