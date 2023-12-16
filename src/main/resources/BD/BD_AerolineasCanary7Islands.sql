-- Eliminar la base de datos si existe
DROP DATABASE IF EXISTS Aerolinea;

-- Crear la base de datos
CREATE DATABASE Aerolinea;

-- Usar la base de datos
USE Aerolinea;

-- Creación de la tabla Vuelo primero (ya que otras tablas dependen de ella)
CREATE TABLE Vuelos (
   Cod_Vuelo VARCHAR(10) PRIMARY KEY NOT NULL,
   Precio FLOAT NOT NULL,  
   Fecha_Salida VARCHAR(19) NOT NULL,  -- formato fechas: "YYYY-MM-DD HH:MI:SS"
   Fecha_Llegada VARCHAR(19) NOT NULL,
   Destino VARCHAR(50) NOT NULL,
   Procedencia VARCHAR(50) NOT NULL,
   Plazas_Turista INT,
   Plazas_Primera INT
);

CREATE TABLE Usuarios(
    Id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Contraseña VARCHAR(50) NOT NULL,
    Mail VARCHAR(50) NOT NULL unique,
    Tlf INT CHECK (Tlf >= 100000000 AND Tlf <= 999999999)
);

-- Creación de la tabla Pasajeros
CREATE TABLE Pasajeros (
   Id_Pasajero INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
   CodVuelo VARCHAR(10) NOT NULL,
   Tipo_plaza VARCHAR(50) NOT NULL,
   FOREIGN KEY (Id_Pasajero) REFERENCES Usuarios(Id),
   FOREIGN KEY (CodVuelo) REFERENCES Vuelos(Cod_Vuelo)
);

CREATE TABLE Administradores(
  Id_Admin INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  Sueldo FLOAT,
  FOREIGN KEY (Id_Admin) REFERENCES Usuarios(Id)
);

-- Creación de la tabla BilletesComprados
CREATE TABLE BilletesComprados (
   Fecha VARCHAR(30) NOT NULL,
   CodVuelo VARCHAR(10) NOT NULL,
   IdPasajero INT NOT NULL,   
   PRIMARY KEY (Fecha, CodVuelo, IdPasajero),
   FOREIGN KEY (IdPasajero) REFERENCES Pasajeros(Id_Pasajero),
   FOREIGN KEY (CodVuelo) REFERENCES Vuelos(Cod_Vuelo)
);

INSERT INTO Usuarios (Nombre, Contraseña, Mail, Tlf) VALUES ("Ana","123","lineasCanary7Island@gmail.com",928417756);
INSERT INTO Administradores (Sueldo) values (2000);
-- Insertar vuelos
INSERT INTO Vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ('ABC123', 250.00, '2023-12-20 08:00:00', '2023-12-21 10:30:00', 'Tenerife', 'Gran Canaria', 100, 20);

INSERT INTO Vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ('DEF456', 180.50, '2023-12-22 12:30:00', '2023-12-23 14:45:00', 'Gran Canaria', 'Tenerife', 120, 15);

INSERT INTO Vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ('GHI789', 300.75, '2023-12-25 09:15:00', '2023-12-26 13:00:00', 'Tenerife', 'Gran Canaria', 200, 30);
