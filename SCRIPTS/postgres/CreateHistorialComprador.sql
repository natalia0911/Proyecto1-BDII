-- Table: public.HistorialComprador

-- DROP TABLE public."HistorialComprador";

CREATE TABLE public."HistorialComprador"
(
    "IDcomprador" numeric(20,0) NOT NULL,
    "IDvendedor" numeric(20,0) NOT NULL,
    "Calificacion" numeric(1,0) NOT NULL,
    "Comentario" character varying COLLATE pg_catalog."default",
    CONSTRAINT "HistorialComprador_pkey" PRIMARY KEY ("IDcomprador", "IDvendedor"),
    CONSTRAINT "IDcomprador" FOREIGN KEY ("IDcomprador")
        REFERENCES public."Usuarios" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT "IDvendedor" FOREIGN KEY ("IDvendedor")
        REFERENCES public."Usuarios" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public."HistorialComprador"
    OWNER to postgres;