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
   Id_Pasajero INT PRIMARY KEY NOT NULL,
   Tipo_plaza VARCHAR(50) NOT NULL,
   FOREIGN KEY (Id_Pasajero) REFERENCES Usuarios(Id)
);

CREATE TABLE Administradores(
  Id_Admin INT PRIMARY KEY NOT NULL,
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

INSERT INTO Usuarios (Nombre, Contraseña, Mail, Tlf) VALUES ("Ana","123","Canary7IslandAIPonceP@gmail.com",928418775);
INSERT INTO Administradores (Id_Admin,Sueldo) values (1,2000);
INSERT INTO Usuarios (Nombre, Contraseña, Mail, Tlf) VALUES ("Jose","123","Canary7IslandJose@gmail.com",928418775);

Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("GC01", 100, "2023-12-20 10:00:00", "2023-12-20 12:00:00", "Gran Canaria", "Tenerife", 100, 20);
Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("GC02", 120, "2023-12-21 10:00:00", "2023-12-21 12:00:00", "Gran Canaria", "Lanzarote", 100, 20);

Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("T01", 130, "2023-12-22 16:00:00", "2023-12-22 18:00:00", "Tenerife","Gran Canaria", 100, 20);
Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("T02", 180, "2023-12-23 15:00:00", "2023-12-23 17:00:00", "Tenerife","El Hierro", 100, 20);

Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("LZ01", 100, "2023-12-23 12:00:00", "2023-12-23 14:00:00", "Lanzarote","Gran Canaria", 100, 20);
Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("LZ02", 200, "2023-12-24 09:00:00", "2023-12-24 11:00:00", "Lanzarote","La Gomera", 100, 20);

Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("FT01", 130, "2024-01-01 13:00:00", "2024-01-01 15:00:00", "Fuerteventura","Tenerife", 100, 20);
Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("FT02", 90, "2024-02-05 09:00:00", "2024-02-05 11:00:00", "Fuerteventura","La Palma", 100, 20);

Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("GM01", 130, "2024-01-15 14:00:00", "2024-01-15 16:00:00", "La Gomera","Tenerife", 100, 20);
Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("GM02", 90, "2024-02-05 09:30:00", "2024-02-05 11:30:00", "La Gomera","El Hierro", 100, 20);

Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("LP01", 130, "2024-01-17 14:00:00", "2024-01-17 16:00:00", "La Palma","Gran Canaria", 100, 20);
Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("LP02", 90, "2024-02-06 09:30:00", "2024-02-06 11:30:00", "La Palma","Lanzarote", 100, 20);

Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("EH01", 130, "2023-12-24 16:00:00", "2023-12-24 18:00:00", "El Hierro","Lanzarote", 100, 20);
Insert INTO vuelos (Cod_Vuelo, Precio, Fecha_Salida, Fecha_Llegada, Destino, Procedencia, Plazas_Turista, Plazas_Primera)
VALUES ("EH02", 180, "2023-12-27 15:00:00", "2023-12-27 17:00:00", "El Hierro","Fuerteventura", 100, 20);

INSERT INTO Pasajeros (Id_Pasajero, Tipo_plaza) VALUES (2,"Turista");
INSERT INTO BilletesComprados (Fecha, CodVuelo, IdPasajero) VALUES
("2023-12-19 08:30:00", "GC01", 2),
("2023-12-20 08:45:00", "GC02", 2);