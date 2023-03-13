/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     07/03/2023 22:01:13                          */
/*==============================================================*/


drop index CLIENTES_PK;

drop table CLIENTES;

drop index CLIENTE_DIRECCION_FK;

drop index CLIENTE_DIRECCION2_FK;

drop index CLIENTE_DIRECCION_PK;

drop table CLIENTE_DIRECCION;

drop index DIRECCIONES_PK;

drop table DIRECCIONES;

drop index CLIENTE_PRODUCTO_FK;

drop index PRODUCTOS_PK;

drop table PRODUCTOS;

drop index CLIENTE_SERVICIO_FK;

drop index PRODUCTO_SERVICIO_FK;

drop index SERVICIOS_PK;

drop table SERVICIOS;

/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES (
   ID_CLIENTE           INT4                 not null,
   NOMBRE               VARCHAR(1024)        not null,
   APELLIDO             VARCHAR(1024)        not null,
   TELEFONO             VARCHAR(1024)        not null,
   EMAIL                TEXT                 null,
   constraint PK_CLIENTES primary key (ID_CLIENTE)
);

/*==============================================================*/
/* Index: CLIENTES_PK                                           */
/*==============================================================*/
create unique index CLIENTES_PK on CLIENTES (
ID_CLIENTE
);

/*==============================================================*/
/* Table: CLIENTE_DIRECCION                                     */
/*==============================================================*/
create table CLIENTE_DIRECCION (
   ID_DIRECCIONES       INT4                 not null,
   ID_CLIENTE           INT4                 not null,
   constraint PK_CLIENTE_DIRECCION primary key (ID_DIRECCIONES, ID_CLIENTE)
);

/*==============================================================*/
/* Index: CLIENTE_DIRECCION_PK                                  */
/*==============================================================*/
create unique index CLIENTE_DIRECCION_PK on CLIENTE_DIRECCION (
ID_DIRECCIONES,
ID_CLIENTE
);

/*==============================================================*/
/* Index: CLIENTE_DIRECCION2_FK                                 */
/*==============================================================*/
create  index CLIENTE_DIRECCION2_FK on CLIENTE_DIRECCION (
ID_CLIENTE
);

/*==============================================================*/
/* Index: CLIENTE_DIRECCION_FK                                  */
/*==============================================================*/
create  index CLIENTE_DIRECCION_FK on CLIENTE_DIRECCION (
ID_DIRECCIONES
);

/*==============================================================*/
/* Table: DIRECCIONES                                           */
/*==============================================================*/
create table DIRECCIONES (
   ID_DIRECCIONES       INT4                 not null,
   CIUDAD               VARCHAR(1024)        not null,
   SECTOR               VARCHAR(1024)        not null,
   CALLE                TEXT                 null,
   NUM_CASA             TEXT                 null,
   REFERENCIA           TEXT                 null,
   constraint PK_DIRECCIONES primary key (ID_DIRECCIONES)
);

/*==============================================================*/
/* Index: DIRECCIONES_PK                                        */
/*==============================================================*/
create unique index DIRECCIONES_PK on DIRECCIONES (
ID_DIRECCIONES
);

/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS (
   ID_PRODUCTO          INT4                 not null,
   ID_CLIENTE           INT4                 not null,
   PRODUCTO             VARCHAR(1024)        not null,
   MARCA                VARCHAR(1024)        not null,
   MODELO               VARCHAR(1024)        null,
   TIPO                 VARCHAR(1024)        not null,
   constraint PK_PRODUCTOS primary key (ID_PRODUCTO)
);

/*==============================================================*/
/* Index: PRODUCTOS_PK                                          */
/*==============================================================*/
create unique index PRODUCTOS_PK on PRODUCTOS (
ID_PRODUCTO
);

/*==============================================================*/
/* Index: CLIENTE_PRODUCTO_FK                                   */
/*==============================================================*/
create  index CLIENTE_PRODUCTO_FK on PRODUCTOS (
ID_CLIENTE
);

/*==============================================================*/
/* Table: SERVICIOS                                             */
/*==============================================================*/
create table SERVICIOS (
   ID_SERVICIO          INT4                 not null,
   ID_PRODUCTO          INT4                 null,
   ID_CLIENTE           INT4                 not null,
   FECHA_VISITA         DATE                 not null,
   SERVICIO_REALIZADO   TEXT                 not null,
   REPUESTO             VARCHAR(1024)        null,
   MESES_GARANTIA       INT4                 null,
   G_F                  VARCHAR(1024)        not null,
   constraint PK_SERVICIOS primary key (ID_SERVICIO)
);

/*==============================================================*/
/* Index: SERVICIOS_PK                                          */
/*==============================================================*/
create unique index SERVICIOS_PK on SERVICIOS (
ID_SERVICIO
);

/*==============================================================*/
/* Index: PRODUCTO_SERVICIO_FK                                  */
/*==============================================================*/
create  index PRODUCTO_SERVICIO_FK on SERVICIOS (
ID_PRODUCTO
);

/*==============================================================*/
/* Index: CLIENTE_SERVICIO_FK                                   */
/*==============================================================*/
create  index CLIENTE_SERVICIO_FK on SERVICIOS (
ID_CLIENTE
);

alter table CLIENTE_DIRECCION
   add constraint FK_CLIENTE__CLIENTE_D_DIRECCIO foreign key (ID_DIRECCIONES)
      references DIRECCIONES (ID_DIRECCIONES)
      on delete restrict on update restrict;

alter table CLIENTE_DIRECCION
   add constraint FK_CLIENTE__CLIENTE_D_CLIENTES foreign key (ID_CLIENTE)
      references CLIENTES (ID_CLIENTE)
      on delete restrict on update restrict;

alter table PRODUCTOS
   add constraint FK_PRODUCTO_CLIENTE_P_CLIENTES foreign key (ID_CLIENTE)
      references CLIENTES (ID_CLIENTE)
      on delete restrict on update restrict;

alter table SERVICIOS
   add constraint FK_SERVICIO_CLIENTE_S_CLIENTES foreign key (ID_CLIENTE)
      references CLIENTES (ID_CLIENTE)
      on delete restrict on update restrict;

alter table SERVICIOS
   add constraint FK_SERVICIO_PRODUCTO__PRODUCTO foreign key (ID_PRODUCTO)
      references PRODUCTOS (ID_PRODUCTO)
      on delete restrict on update restrict;

