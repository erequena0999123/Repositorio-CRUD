/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     07/03/2023 22:00:22                          */
/*==============================================================*/


drop table if exists CLIENTES;

drop table if exists CLIENTE_DIRECCION;

drop table if exists DIRECCIONES;

drop table if exists PRODUCTOS;

drop table if exists SERVICIOS;

/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES
(
   ID_CLIENTE           int not null,
   NOMBRE               varchar(1024) not null,
   APELLIDO             varchar(1024) not null,
   TELEFONO             varchar(1024) not null,
   EMAIL                text,
   primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Table: CLIENTE_DIRECCION                                     */
/*==============================================================*/
create table CLIENTE_DIRECCION
(
   ID_DIRECCIONES       int not null,
   ID_CLIENTE           int not null,
   primary key (ID_DIRECCIONES, ID_CLIENTE)
);

/*==============================================================*/
/* Table: DIRECCIONES                                           */
/*==============================================================*/
create table DIRECCIONES
(
   ID_DIRECCIONES       int not null,
   CIUDAD               varchar(1024) not null,
   SECTOR               varchar(1024) not null,
   CALLE                text,
   NUM_CASA             text,
   REFERENCIA           text,
   primary key (ID_DIRECCIONES)
);

/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS
(
   ID_PRODUCTO          int not null,
   ID_CLIENTE           int not null,
   PRODUCTO             varchar(1024) not null,
   MARCA                varchar(1024) not null,
   MODELO               varchar(1024),
   TIPO                 varchar(1024) not null,
   primary key (ID_PRODUCTO)
);

/*==============================================================*/
/* Table: SERVICIOS                                             */
/*==============================================================*/
create table SERVICIOS
(
   ID_SERVICIO          int not null,
   ID_PRODUCTO          int,
   ID_CLIENTE           int not null,
   FECHA_VISITA         date not null,
   SERVICIO_REALIZADO   text not null,
   REPUESTO             varchar(1024),
   MESES_GARANTIA       int,
   G_F                  varchar(1024) not null,
   primary key (ID_SERVICIO)
);

alter table CLIENTE_DIRECCION add constraint FK_CLIENTE_DIRECCION foreign key (ID_DIRECCIONES)
      references DIRECCIONES (ID_DIRECCIONES) on delete restrict on update restrict;

alter table CLIENTE_DIRECCION add constraint FK_CLIENTE_DIRECCION2 foreign key (ID_CLIENTE)
      references CLIENTES (ID_CLIENTE) on delete restrict on update restrict;

alter table PRODUCTOS add constraint FK_CLIENTE_PRODUCTO foreign key (ID_CLIENTE)
      references CLIENTES (ID_CLIENTE) on delete restrict on update restrict;

alter table SERVICIOS add constraint FK_CLIENTE_SERVICIO foreign key (ID_CLIENTE)
      references CLIENTES (ID_CLIENTE) on delete restrict on update restrict;

alter table SERVICIOS add constraint FK_PRODUCTO_SERVICIO foreign key (ID_PRODUCTO)
      references PRODUCTOS (ID_PRODUCTO) on delete restrict on update restrict;

