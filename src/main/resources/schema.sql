CREATE SCHEMA ECOMMERCE;

-- auto-generated definition
create table STORE
(
    ID          INTEGER auto_increment,
    NAME        CHARACTER VARYING not null,
    DESCRIPTION CHARACTER VARYING,
    ADDRESS     CHARACTER VARYING,
    constraint STORE_PK
        primary key (ID)
);

create unique index STORE_ID_UINDEX
    on STORE (ID);

-- auto-generated definition
create table PRODUCT
(
    ID          CHARACTER VARYING not null,
    NAME        CHARACTER VARYING,
    DESCRIPTION CHARACTER VARYING,
    image_URL   CHARACTER VARYING,
    PRICE       CHARACTER VARYING,
    STORE_ID    INTEGER,
    constraint PRODUCT_PK
        primary key (ID),
    constraint PRODUCT_STORE_ID_FK
        foreign key (STORE_ID) references STORE
);

create unique index PRODUCT_ID_UINDEX
    on PRODUCT (ID);


