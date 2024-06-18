-----------------------------------------------
CREATE NEW SCHEMA ORACLE
alter session set "_ORACLE_SCRIPT"=true;

create USER PAYMENTS identified by p4ym3nt;

GRANT CONNECT TO PAYMENTS;

GRANT dba TO PAYMENTS;

-----------------------------------------------

create sequence SEQ_ARANCEL;

create sequence SEQ_USUARIO;

create sequence SEQ_ALUMNO;

create sequence SEQ_VENTA;

create sequence SEQ_DETALLE_VENTA;

create sequence SEQ_ESTADO;

create sequence SEQ_TUTOR;

create sequence SEQ_ALUMNO_TUTOR;

create table TBL_ARANCEL
(
    ARANCEL_ID     NUMBER       not null
        primary key,
    NOMBRE         VARCHAR2(60) not null,
    PRECIO         FLOAT,
    OPCIONAL       CHAR,
    FECHA_REGISTRO DATE,
    ESTADO         NUMBER       not null
);

create table TBL_USUARIO
(
    USUARIO_ID     NUMBER        not null
        primary key,
    APELLIDO       VARCHAR2(60)  not null,
    NOMBRE         VARCHAR2(60)  not null,
    DIRECCION      VARCHAR2(400) not null,
    TELEFONO       VARCHAR2(20),
    CORREO         VARCHAR2(60),
    NOMBRE_USUARIO VARCHAR2(60)  not null
        unique,
    PASSWORD       VARCHAR2(60)  not null,
    FECHA_REGISTRO DATE,
    ESTADO         NUMBER        not null
);

create table TBL_ALUMNO
(
    ALUMNO_ID      NUMBER       not null
        primary key,
    CODIGO_ALUMNO  VARCHAR2(60) not null
        unique,
    APELLIDO       VARCHAR2(60) not null,
    NOMBRE         VARCHAR2(60) not null,
    FECHA_REGISTRO DATE,
    ESTADO         NUMBER       not null
);

create table TBL_ESTADO
(
    ESTADO_ID      NUMBER           not null
        primary key,
    CODIGO_ESTADO  NUMBER           not null
        unique,
    NOMBRE_ESTADO  VARCHAR2(60),
    FECHA_REGISTRO DATE,
    ESTADO         CHAR default '1' not null
);

create table TBL_VENTA
(
    VENTA_ID       NUMBER       not null
        primary key,
    ALUMNO_ID      NUMBER       not null
        constraint FK_ALUMNO
            references TBL_ALUMNO,
    NOMBRE_CLIENTE VARCHAR2(60),
    DESCRIPCION    VARCHAR2(128),
    USUARIO_ID     NUMBER       not null
        constraint FK_USUARIO
            references TBL_USUARIO,
    FECHA_VENTA    DATE,
    DESCUENTO      NUMBER(9, 2) not null,
    SUBTOTAL       NUMBER(9, 2) not null,
    IVA            NUMBER(9, 2) not null,
    TOTAL          NUMBER(9, 2) not null,
    ESTADO         NUMBER       not null
);

create table TBL_TUTOR
(
    TUTOR_ID       NUMBER        not null
        primary key,
    APELLIDO       VARCHAR2(60),
    NOMBRE         VARCHAR2(60),
    DIRECCION      VARCHAR2(400) not null,
    TELEFONO       VARCHAR2(20),
    CORREO         VARCHAR2(60),
    FECHA_REGISTRO DATE,
    ESTADO         NUMBER        not null
);

create table TBL_ALUMNO_TUTOR
(
    ALUMNO_TUTOR_ID NUMBER not null
        primary key,
    ALUMNO_ID       NUMBER not null
        constraint FK_DETALLE_ALUMNO_TUTOR
            references TBL_ALUMNO,
    TUTOR_ID        NUMBER not null
        constraint FK_DETALLE_TUTOR_ALUMNO
            references TBL_TUTOR,
    FECHA_REGISTRO  DATE,
    ESTADO          NUMBER not null
);

create table TBL_DETALLE_VENTA
(
    DETALLE_VENTA_ID NUMBER       not null
        primary key,
    VENTA_ID         NUMBER       not null
        constraint FK_VENTA
            references TBL_VENTA,
    ARANCEL_ID       NUMBER       not null
        constraint FK_ARANCEL
            references TBL_ARANCEL,
    CANTIDAD         NUMBER(6)    not null,
    PRECIO           NUMBER(6, 2) not null,
    DESCUENTO        NUMBER(9, 2) not null,
    SUBTOTAL         NUMBER(9, 2) not null,
    IVA              NUMBER(9, 2) not null,
    TOTAL            NUMBER(9, 2) not null,
    ESTADO           NUMBER       not null
);


