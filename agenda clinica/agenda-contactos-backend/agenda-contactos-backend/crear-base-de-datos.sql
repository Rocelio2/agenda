-- Ejecutar en SSMS con Windows Authentication. No cambia la configuración global de seguridad de SQL Server.
IF DB_ID('agenda_clinica') IS NULL CREATE DATABASE agenda_clinica;
GO
IF SUSER_ID('agenda_app') IS NULL CREATE LOGIN agenda_app WITH PASSWORD='Agenda#2026', CHECK_POLICY=ON;
GO
USE agenda_clinica;
GO
IF USER_ID('agenda_app') IS NULL CREATE USER agenda_app FOR LOGIN agenda_app;
GO
ALTER ROLE db_datareader ADD MEMBER agenda_app;
ALTER ROLE db_datawriter ADD MEMBER agenda_app;
ALTER ROLE db_ddladmin ADD MEMBER agenda_app;
GO
-- Hibernate crea/actualiza las tablas a partir de las entidades JPA.
