-- Table: public.Images

-- DROP TABLE public."Images";

CREATE TABLE public."Images"
(
    "IDsubasta" numeric(20,0) NOT NULL,
    imagen bytea NOT NULL,
    CONSTRAINT "Images_pkey" PRIMARY KEY ("IDsubasta"),
    CONSTRAINT "IDsubasta" FOREIGN KEY ("IDsubasta")
        REFERENCES public.subastas ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public."Images"
    OWNER to postgres;