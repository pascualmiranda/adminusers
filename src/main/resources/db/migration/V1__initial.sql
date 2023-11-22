-- crear tabla user
create table "user" (
                         id bigint not null,
                         username varchar(150) not null,
                         password varchar(150) not null,
                         email varchar(150),
                         created_at timestamp,
                         primary key (id)
);

-- crear sequence para user ide
create sequence user_sequence as bigint increment 1;

-- crear tabla user_detail
create table user_detail (
                         id bigint not null,
                         first_name varchar(100) not null,
                         last_name varchar(100) not null,
                         age int,
                         birth_day date,
                         user_id bigint,
                         primary key (id)
);

-- crear sequence para user_detail ide
create sequence user_detail_sequence as bigint increment 1;

-- añadir user_id FK en la tabla user_detail
alter table user_detail add constraint FK_user_detail_RefUser foreign key (user_id)
    references "user" (id) on delete restrict on update restrict;

-- crear tabla rol
create table rol (
                        id integer not null,
                        name varchar(100) not null,
                        primary key (id)
);

-- crear sequence para rol ide
create sequence rol_sequence as integer increment 1;

-- crear tabla user_rol
create table user_rol (
			id integer not null,
			active boolean not null,
			created_at timestamp not null,
			user_id bigint,
			rol_id integer,
			primary key (id)
);

-- crear sequence para user_ide ide
create sequence user_rol_sequence as integer increment 1;

-- añadir user_id FK en la tabla user_rol
alter table user_rol add constraint FK_user_rol_RefUser foreign key (user_id)
    references "user" (id) on delete restrict on update restrict;

-- añadir rol_id FK en la tabla user_rol
alter table user_rol add constraint FK_user_rol_RefRol foreign key (rol_id)
    references rol (id) on delete restrict on update restrict;

