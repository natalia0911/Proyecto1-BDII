

CREATE TABLE Categoria (
    Id DECIMAL NOT NULL,
    Nombre NVARCHAR2(128) NOT NULL,
    CONSTRAINT ID_CATEGORIA_PK PRIMARY KEY (Id)
);

CREATE TABLE SubCategoria (
    Id DECIMAL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1)  NOT NULL,
    Nombre NVARCHAR2(128) NOT NULL,
    CategoriaId DECIMAL NOT NULL,
    CONSTRAINT ID_SUBCATEGORIA_PK PRIMARY KEY (Id)
);

CREATE TABLE Usuario (
    Id DECIMAL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1)  NOT NULL,
    Nombre NVARCHAR2(128) NOT NULL,
    Cedula DECIMAL NOT NULL,
    Direccion NVARCHAR2(128) NOT NULL,
    Correo  NVARCHAR2(128) NOT NULL,
    EsAdmin INT check (EsAdmin in (0,1)),
    Alias NVARCHAR2(128) NOT NULL,
    Contrasennia NVARCHAR2(128) NOT NULL,
    CONSTRAINT ID_USUARIO_PK PRIMARY KEY (Id),
    CONSTRAINT UQ_CEDULA UNIQUE (Cedula)
);

CREATE TABLE TipoTelefono(
    Id DECIMAL NOT NULL,
    Nombre NVARCHAR2(128) NOT NULL,
    CONSTRAINT ID_TIPOTEL_PK PRIMARY KEY (Id)
);

CREATE TABLE Telefono (
    Id DECIMAL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1)  NOT NULL,
    Numero INT NOT NULL,
    --Tipo DECIMAL NOT NULL,
    Usuario DECIMAL NOT NULL,
    CONSTRAINT ID_TELEFONO_PK PRIMARY KEY (Id),
    --CONSTRAINT ID_Tipo_TEL_FK FOREIGN KEY (Tipo) REFERENCES TipoTelefono(Id),
    CONSTRAINT ID_USUARIO_FK FOREIGN KEY (Usuario) REFERENCES Usuario(Id)
);

CREATE TABLE Subasta (
    Id DECIMAL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1)  NOT NULL,
    UsuarioId DECIMAL NOT NULL,
    compradorId DECIMAL NOT NULL,
    SubCategoriaId DECIMAL NOT NULL,
    FotoItem NVARCHAR2(128),
    PrecioInicial DECIMAL NOT NULL,
    PrecioFinal DECIMAL NOT NULL,
    DetallesEntrega NVARCHAR2(128) NOT NULL,
    FechaInicio DATE NOT NULL,
    FechaFin DATE NOT NULL,
    Activa INT check (Activa in (0,1)),
    CONSTRAINT ID_SUBASTA_PK PRIMARY KEY (Id),
    CONSTRAINT ID_USUARIO_VENDEDOR_FK FOREIGN KEY (UsuarioId) REFERENCES Usuario(Id),
    CONSTRAINT ID_SUBCATEGORIA_FK FOREIGN KEY (SubCategoriaId) REFERENCES SubCategoria(Id),
    CONSTRAINT ID_USUARIO_VENDEDOR_FK FOREIGN KEY (compradorId)REFERENCES USUARIO(Id)
);




CREATE TABLE Pujas (
    Id DECIMAL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1)  NOT NULL,
    CompradorId DECIMAL NOT NULL,
    SubastaId DECIMAL NOT NULL,
    Precio DECIMAL NOT NULL,
    Fecha DATE NOT NULL,
    CONSTRAINT ID_PUJA_PK PRIMARY KEY (Id),
    CONSTRAINT ID_USUARIO_COMPRADOR_FK FOREIGN KEY (CompradorId) REFERENCES Usuario(Id),
    CONSTRAINT ID_SUBASTA_FK FOREIGN KEY (SubastaId) REFERENCES Subasta(Id)
);



CREATE TABLE HistorialComprador (
    IdComprador DECIMAL NOT NULL,
    IdVendedor DECIMAL NOT NULL,
    IdSubasta DECIMAL NOT NULL,
    Comentario NVARCHAR2(128) NOT NULL,
    Calificacion INT NOT NULL,
    CONSTRAINT ID_USUARIO_COMPARDOR_EN_HISTCOMPRADOR_FK FOREIGN KEY (IdComprador) REFERENCES Usuario(Id),
    CONSTRAINT ID_USUARIO_VENDEDOR_EN_HISTCOMPRADOR_FK FOREIGN KEY (IdVendedor) REFERENCES Usuario(Id),
    CONSTRAINT ID_SUBASTA_EN_HISTCOMPRADOR_FK FOREIGN KEY (IdSubasta) REFERENCES Subasta(Id)
);



CREATE TABLE HistorialVendedor (
    IdVendedor DECIMAL NOT NULL,
    IdComprador DECIMAL NOT NULL,
    IdSubasta DECIMAL NOT NULL,
    Comentario NVARCHAR2(128) NOT NULL,
    Calificacion INT NOT NULL,
    CONSTRAINT ID_USUARIO_VENDEDOR_EN_HISTVENDEDOR_FK FOREIGN KEY (IdVendedor) REFERENCES Usuario(Id),
    CONSTRAINT ID_USUARIO_COMPARDOR_EN_HISTVENDEDOR_FK FOREIGN KEY (IdComprador) REFERENCES Usuario(Id),
    CONSTRAINT ID_SUBASTA_EN_HISTVENDEDOR_FK FOREIGN KEY (IdSubasta) REFERENCES Subasta(Id)

);


CREATE TABLE IMAGENES(
    IMAGENID DECIMAL,
    IMAGEN BLOB,
    CONSTRAINT IMAGENID FOREIGN KEY (IMAGENID) REFERENCES Subasta(ID)
);


CREATE TABLE SystemParameters(
    CodParameter NVARCHAR2(64) NOT NULL,
    Valor DECIMAL NOT NULL
);

INSERT INTO SystemParameters(CODPARAMETER,VALOR) VALUES ('PERC',5);  --Percentage
INSERT INTO SystemParameters(CODPARAMETER,VALOR) VALUES ('MIN',5000);  --Minimum

