create database veterinaria;

use veterinaria;

CREATE TABLE Tipo_Usuario (
    idTipoUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre NVARCHAR(20) NOT NULL
);

CREATE TABLE Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre NVARCHAR(30) NOT NULL,
    correo NVARCHAR(30) NOT NULL UNIQUE,
    contrasenia NVARCHAR(16) NOT NULL,
    idTipoUsuario INT NOT NULL,
    FOREIGN KEY (idTipoUsuario) REFERENCES Tipo_Usuario(idTipoUsuario)
);

CREATE TABLE Cita (
    idCita INT AUTO_INCREMENT PRIMARY KEY,
    nombreMascota NVARCHAR(30) NOT NULL,
    especie NVARCHAR(30) NOT NULL,
    fecha DATE NOT NULL,
    horaInicio TIME NOT NULL,
    horaFin TIME,
    idCliente INT NOT NULL,
    idAdmin INT,
    FOREIGN KEY (idCliente) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idAdmin) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Factura (
   idFactura INT AUTO_INCREMENT PRIMARY KEY,
   fecha DATE NOT NULL,
   estado CHAR NOT NULL,
   idUsuario INT NOT NULL,
   FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Tipo_Producto (
    idTipoProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre NVARCHAR(30) NOT NULL
);

CREATE TABLE Producto (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre NVARCHAR(30) NOT NULL,
    precio DECIMAL(5, 2) NOT NULL,
    existencia INT NOT NULL,
    descripcion TEXT,
    idTipoProducto INT NOT NULL,
    FOREIGN KEY (idTipoProducto) REFERENCES Tipo_Producto(idTipoProducto)
);

CREATE TABLE Detalle_Producto (
    idProducto INT,
    idFactura INT,
    cantidad INT NOT NULL,
    PRIMARY KEY (idProducto, idFactura),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto),
    FOREIGN KEY (idFactura) REFERENCES Factura(idFactura)
);
