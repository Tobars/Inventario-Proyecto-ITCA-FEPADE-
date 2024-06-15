create database Inventario;

use Inventario;

create table Categorias(
	categoria_id INT primary key not null AUTO_INCREMENT,
	nombre_categoria VARCHAR(50) not null,
	descripcion VARCHAR(100) not null
);

create table Proveedores(
	proveedor_id INT primary key not null AUTO_INCREMENT,
	nombre_proveedor VARCHAR(50) not null
);

create table Productos(
	producto_id INT primary key not null AUTO_INCREMENT,
	nombre_producto VARCHAR(50) not null,
	precio FLOAT not null,
	inStock INT not null,
	foto longblob not null,
	categoria_id INT not null,
	proveedor_id int not null,
	
	-- Relación con la tabla Categorías
	foreign KEY(categoria_id) references Categorias(categoria_id),
	foreign key(proveedor_id) references Proveedores(proveedor_id)
);

create table Tipos_Procesos(
	proceso_id INT primary key not null AUTO_INCREMENT,
	nombre_proceso varchar(7) not null,
	descripcion varchar(100) not null
);



create table Detalles_Procesos(
	detalle_proceso_id INT primary key not null AUTO_INCREMENT,
	producto_id INT not null,
	proceso_id INT not null,
	cantidad int not null,
	
	-- Relación con las tablas Productos y Procesos
	foreign KEY(producto_id) references Productos(producto_id),
	foreign KEY(proceso_id) references Tipos_Procesos(proceso_id)
);

-- Realizando insert de los procesos por defecto (ENTRADA, SALIDA)
insert into tipos_procesos  (nombre_proceso, descripcion) values ('Entrada', 'Ingreso de productos al inventario');
insert into tipos_procesos  (nombre_proceso, descripcion) values ('Salida', 'Venta de productos');