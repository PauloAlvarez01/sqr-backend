-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2026-04-22 00:28:48.707

-- tables
-- Table: CIRUGIA
CREATE TABLE CIRUGIA (
    id_cirugia serial  NOT NULL,
    nombre_cirugia varchar(25)  NOT NULL,
    CONSTRAINT AK_CIRUGIA UNIQUE (nombre_cirugia) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_CIRUGIA PRIMARY KEY (id_cirugia)
);

-- Table: CIRUJANO
CREATE TABLE CIRUJANO (
    matricula int  NOT NULL,
    apellido_cirujano varchar(25)  NOT NULL,
    nombre_cirujano varchar(25)  NOT NULL,
    email_cirujano varchar(25)  NOT NULL,
    telefono_cirujano varchar(25)  NOT NULL,
    id_especialidad int  NOT NULL,
    activo_cirujano boolean  NOT NULL,
    CONSTRAINT PK_CIRUJANO PRIMARY KEY (matricula)
);

-- Table: DISPONIBILIDAD_PERSONAL
CREATE TABLE DISPONIBILIDAD_PERSONAL (
    id_disponibilidad_personal serial  NOT NULL,
    fecha_disponibilidad_personal date  NOT NULL,
    hora_inicio time  NOT NULL,
    hora_fin time  NOT NULL,
    legajo int  NOT NULL,
    id_estado_personal int  NOT NULL,
    creado_por varchar(25)  NOT NULL,
    fecha_creacion timestamp  NOT NULL,
    modificado_por varchar(25)  NOT NULL,
    fecha_modificacion timestamp  NOT NULL,
    CONSTRAINT PK_DISPONIBILIDAD_PERSONAL PRIMARY KEY (id_disponibilidad_personal)
);

-- Table: EQUIPO
CREATE TABLE EQUIPO (
    id_equipo serial  NOT NULL,
    nombre_equipo varchar(25)  NOT NULL,
    es_movil boolean  NOT NULL,
    id_estado_equipo int  NOT NULL,
    id_quirofano int  NULL,
    CONSTRAINT PK_EQUIPO PRIMARY KEY (id_equipo)
);

-- Table: ESPECIALIDAD
CREATE TABLE ESPECIALIDAD (
    id_especialidad serial  NOT NULL,
    nombre_especialidad varchar(25)  NOT NULL,
    CONSTRAINT AK_ESPECIALIDAD UNIQUE (nombre_especialidad) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_ESPECIALIDAD PRIMARY KEY (id_especialidad)
);

-- Table: ESTADO_EQUIPO
CREATE TABLE ESTADO_EQUIPO (
    id_estado_equipo serial  NOT NULL,
    nombre_estado_equipo varchar(25)  NOT NULL,
    CONSTRAINT AK_ESTADO_EQUIPO UNIQUE (nombre_estado_equipo) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_ESTADO_EQUIPO PRIMARY KEY (id_estado_equipo)
);

-- Table: ESTADO_PERSONAL
CREATE TABLE ESTADO_PERSONAL (
    id_estado_personal serial  NOT NULL,
    nombre_estado_personal varchar(25)  NOT NULL,
    CONSTRAINT AK_ESTADO_PERSONAL UNIQUE (nombre_estado_personal) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_ESTADO_PERSONAL PRIMARY KEY (id_estado_personal)
);

-- Table: ESTADO_QUIROFANO
CREATE TABLE ESTADO_QUIROFANO (
    id_estado_quirofano serial  NOT NULL,
    nombre_estado_quirofano varchar(25)  NOT NULL,
    CONSTRAINT AK_ESTADO_QUIROFANO UNIQUE (nombre_estado_quirofano) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_ESTADO_QUIROFANO PRIMARY KEY (id_estado_quirofano)
);

-- Table: ESTADO_TURNO
CREATE TABLE ESTADO_TURNO (
    id_estado_turno serial  NOT NULL,
    nombre_estado_turno varchar(25)  NOT NULL,
    CONSTRAINT AK_ESTADO_TURNO UNIQUE (nombre_estado_turno) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_ESTADO_TURNO PRIMARY KEY (id_estado_turno)
);

-- Table: EVENTO_TURNO
CREATE TABLE EVENTO_TURNO (
    id_evento_turno serial  NOT NULL,
    id_turno int  NOT NULL,
    id_tipo_evento int  NOT NULL,
    legajo int  NOT NULL,
    timestamp_evento_turno timestamp  NOT NULL,
    CONSTRAINT PK_EVENTO_TURNO PRIMARY KEY (id_evento_turno)
);

-- Table: OBRA_SOCIAL
CREATE TABLE OBRA_SOCIAL (
    id_obra_social int  NOT NULL,
    nombre_obra_social varchar(25)  NOT NULL,
    activa_obra_social boolean  NOT NULL,
    CONSTRAINT AK_OBRA_SOCIAL UNIQUE (nombre_obra_social) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_OBRA_SOCIAL PRIMARY KEY (id_obra_social)
);

-- Table: PACIENTE
CREATE TABLE PACIENTE (
    id_paciente serial  NOT NULL,
    apellido_paciente varchar(25)  NOT NULL,
    nombre_paciente varchar(25)  NOT NULL,
    dni varchar(15)  NOT NULL,
    telefono_paciente varchar(25)  NOT NULL,
    id_obra_social int  NOT NULL,
    fecha_nacimiento_paciente date  NOT NULL,
    sexo varchar(25)  NULL,
    email varchar(100)  NULL,
    creado_por varchar(25)  NOT NULL,
    fecha_creacion timestamp  NOT NULL,
    modificado_por varchar(25)  NOT NULL,
    fecha_modificacion timestamp  NOT NULL,
    CONSTRAINT AK_PACIENTE UNIQUE (dni) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_PACIENTE PRIMARY KEY (id_paciente)
);

-- Table: PERSONAL
CREATE TABLE PERSONAL (
    legajo int  NOT NULL,
    apellido_personal varchar(25)  NOT NULL,
    nombre_personal varchar(25)  NOT NULL,
    id_rol int  NOT NULL,
    activo_personal boolean  NOT NULL,
    CONSTRAINT PK_PERSONAL PRIMARY KEY (legajo)
);

-- Table: POSTOPERATORIO
CREATE TABLE POSTOPERATORIO (
    id_postoperatorio serial  NOT NULL,
    nombre_posoperatorio varchar(5)  NOT NULL,
    CONSTRAINT AK_POSTOPERATORIO UNIQUE (nombre_posoperatorio) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_POSTOPERATORIO PRIMARY KEY (id_postoperatorio)
);

-- Table: QUIROFANO
CREATE TABLE QUIROFANO (
    id_quirofano int  NOT NULL,
    nombre_quirofano varchar(25)  NOT NULL,
    tipo_quirofano varchar(25)  NOT NULL,
    id_estado_quirofano int  NOT NULL,
    CONSTRAINT PK_QUIROFANO PRIMARY KEY (id_quirofano)
);

-- Table: ROL
CREATE TABLE ROL (
    id_rol serial  NOT NULL,
    nombre_rol varchar(25)  NOT NULL,
    CONSTRAINT AK_ROL UNIQUE (nombre_rol) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_ROL PRIMARY KEY (id_rol)
);

-- Table: ROL_SISTEMA
CREATE TABLE ROL_SISTEMA (
    id_rol_sistema serial  NOT NULL,
    nombre_rol_sistema varchar(25)  NOT NULL,
    CONSTRAINT AK_ROL_SISTEMA UNIQUE (nombre_rol_sistema) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_ROL_SISTEMA PRIMARY KEY (id_rol_sistema)
);

-- Table: TIPO_ANESTESIA
CREATE TABLE TIPO_ANESTESIA (
    id_tipo_anestesia serial  NOT NULL,
    nombre_tipo_anestesia varchar(25)  NOT NULL,
    CONSTRAINT AK_TIPO_ANESTESIA UNIQUE (nombre_tipo_anestesia) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_TIPO_ANESTESIA PRIMARY KEY (id_tipo_anestesia)
);

-- Table: TIPO_EVENTO
CREATE TABLE TIPO_EVENTO (
    id_tipo_evento serial  NOT NULL,
    nombre_tipo_evento varchar(25)  NOT NULL,
    CONSTRAINT AK_TIPO_EVENTO UNIQUE (nombre_tipo_evento) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_TIPO_EVENTO PRIMARY KEY (id_tipo_evento)
);

-- Table: TURNO
CREATE TABLE TURNO (
    id_turno serial  NOT NULL,
    id_paciente int  NOT NULL,
    matricula int  NOT NULL,
    id_quirofano int  NULL,
    fecha_cirugia date  NOT NULL,
    hora_inicio_estimada time  NOT NULL,
    hora_inicio_proyectada time  NOT NULL,
    duracion_estimada_minutos int  NOT NULL,
    duracion_proyectada int  NOT NULL,
    id_tipo_anestesia int  NOT NULL,
    id_estado_turno int  NOT NULL,
    urgencia boolean  NOT NULL,
    torre boolean  NOT NULL,
    rx boolean  NOT NULL,
    patologo_presente boolean  NOT NULL,
    fecha_hora_solicitud timestamp  NOT NULL,
    id_cirugia int  NOT NULL,
    otra_cirugia varchar(255)  NULL,
    id_postoperatorio int  NOT NULL,
    creado_por varchar(25)  NOT NULL,
    fecha_creacion timestamp  NOT NULL,
    modificado_por varchar(25)  NOT NULL,
    fecha_modificacion timestamp  NOT NULL,
    CONSTRAINT PK_TURNO PRIMARY KEY (id_turno)
);

-- Table: USUARIO
CREATE TABLE USUARIO (
    id_usuario serial  NOT NULL,
    user_name varchar(25)  NOT NULL,
    password_hash varchar(255)  NOT NULL,
    activo_usuario boolean  NOT NULL,
    matricula int  NULL,
    legajo int  NULL,
    id_rol_sistema int  NOT NULL,
    CONSTRAINT AK_USUARIO UNIQUE (user_name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_USUARIO PRIMARY KEY (id_usuario)
);

-- foreign keys
-- Reference: FK_CIRUJANO_ESPECIALIDAD (table: CIRUJANO)
ALTER TABLE CIRUJANO ADD CONSTRAINT FK_CIRUJANO_ESPECIALIDAD
    FOREIGN KEY (id_especialidad)
    REFERENCES ESPECIALIDAD (id_especialidad)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_DISPONIBILIDAD_PERSONAL_ESTADO_PERSONAL (table: DISPONIBILIDAD_PERSONAL)
ALTER TABLE DISPONIBILIDAD_PERSONAL ADD CONSTRAINT FK_DISPONIBILIDAD_PERSONAL_ESTADO_PERSONAL
    FOREIGN KEY (id_estado_personal)
    REFERENCES ESTADO_PERSONAL (id_estado_personal)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_DISPONIBILIDAD_PERSONAL_PERSONAL (table: DISPONIBILIDAD_PERSONAL)
ALTER TABLE DISPONIBILIDAD_PERSONAL ADD CONSTRAINT FK_DISPONIBILIDAD_PERSONAL_PERSONAL
    FOREIGN KEY (legajo)
    REFERENCES PERSONAL (legajo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_EQUIPO_ESTADO_EQUIPO (table: EQUIPO)
ALTER TABLE EQUIPO ADD CONSTRAINT FK_EQUIPO_ESTADO_EQUIPO
    FOREIGN KEY (id_estado_equipo)
    REFERENCES ESTADO_EQUIPO (id_estado_equipo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_EQUIPO_QUIROFANO (table: EQUIPO)
ALTER TABLE EQUIPO ADD CONSTRAINT FK_EQUIPO_QUIROFANO
    FOREIGN KEY (id_quirofano)
    REFERENCES QUIROFANO (id_quirofano)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_EVENTO_TURNO_PERSONAL (table: EVENTO_TURNO)
ALTER TABLE EVENTO_TURNO ADD CONSTRAINT FK_EVENTO_TURNO_PERSONAL
    FOREIGN KEY (legajo)
    REFERENCES PERSONAL (legajo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_EVENTO_TURNO_TIPO_EVENTO (table: EVENTO_TURNO)
ALTER TABLE EVENTO_TURNO ADD CONSTRAINT FK_EVENTO_TURNO_TIPO_EVENTO
    FOREIGN KEY (id_tipo_evento)
    REFERENCES TIPO_EVENTO (id_tipo_evento)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_EVENTO_TURNO_TURNO (table: EVENTO_TURNO)
ALTER TABLE EVENTO_TURNO ADD CONSTRAINT FK_EVENTO_TURNO_TURNO
    FOREIGN KEY (id_turno)
    REFERENCES TURNO (id_turno)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_PACIENTE_OBRA_SOCIAL (table: PACIENTE)
ALTER TABLE PACIENTE ADD CONSTRAINT FK_PACIENTE_OBRA_SOCIAL
    FOREIGN KEY (id_obra_social)
    REFERENCES OBRA_SOCIAL (id_obra_social)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_PERSONAL_ROL (table: PERSONAL)
ALTER TABLE PERSONAL ADD CONSTRAINT FK_PERSONAL_ROL
    FOREIGN KEY (id_rol)
    REFERENCES ROL (id_rol)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_QUIROFANO_ESTADO_QUIROFANO (table: QUIROFANO)
ALTER TABLE QUIROFANO ADD CONSTRAINT FK_QUIROFANO_ESTADO_QUIROFANO
    FOREIGN KEY (id_estado_quirofano)
    REFERENCES ESTADO_QUIROFANO (id_estado_quirofano)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_TURNO_CIRUGIA (table: TURNO)
ALTER TABLE TURNO ADD CONSTRAINT FK_TURNO_CIRUGIA
    FOREIGN KEY (id_cirugia)
    REFERENCES CIRUGIA (id_cirugia)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_TURNO_CIRUJANO (table: TURNO)
ALTER TABLE TURNO ADD CONSTRAINT FK_TURNO_CIRUJANO
    FOREIGN KEY (matricula)
    REFERENCES CIRUJANO (matricula)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_TURNO_ESTADO_TURNO (table: TURNO)
ALTER TABLE TURNO ADD CONSTRAINT FK_TURNO_ESTADO_TURNO
    FOREIGN KEY (id_estado_turno)
    REFERENCES ESTADO_TURNO (id_estado_turno)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_TURNO_PACIENTE (table: TURNO)
ALTER TABLE TURNO ADD CONSTRAINT FK_TURNO_PACIENTE
    FOREIGN KEY (id_paciente)
    REFERENCES PACIENTE (id_paciente)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_TURNO_POSTOPERATORIO (table: TURNO)
ALTER TABLE TURNO ADD CONSTRAINT FK_TURNO_POSTOPERATORIO
    FOREIGN KEY (id_postoperatorio)
    REFERENCES POSTOPERATORIO (id_postoperatorio)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_TURNO_QUIROFANO (table: TURNO)
ALTER TABLE TURNO ADD CONSTRAINT FK_TURNO_QUIROFANO
    FOREIGN KEY (id_quirofano)
    REFERENCES QUIROFANO (id_quirofano)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_TURNO_TIPO_ANESTESIA (table: TURNO)
ALTER TABLE TURNO ADD CONSTRAINT FK_TURNO_TIPO_ANESTESIA
    FOREIGN KEY (id_tipo_anestesia)
    REFERENCES TIPO_ANESTESIA (id_tipo_anestesia)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_USUARIO_CIRUJANO (table: USUARIO)
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_CIRUJANO
    FOREIGN KEY (matricula)
    REFERENCES CIRUJANO (matricula)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_USUARIO_PERSONAL (table: USUARIO)
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_PERSONAL
    FOREIGN KEY (legajo)
    REFERENCES PERSONAL (legajo)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: FK_USUARIO_ROL_SISTEMA (table: USUARIO)
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_ROL_SISTEMA
    FOREIGN KEY (id_rol_sistema)
    REFERENCES ROL_SISTEMA (id_rol_sistema)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

