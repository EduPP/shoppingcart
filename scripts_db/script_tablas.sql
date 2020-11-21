create database store;

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` int(11) NOT NULL,
  `telefono` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) 

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `precio` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
)

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idVenta`),
  KEY `idCliente_idx` (`idCliente`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE
)

CREATE TABLE `detalleventa` (
  `idDetalleVenta` int(11) NOT NULL AUTO_INCREMENT,
  `idVenta` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  PRIMARY KEY (`idDetalleVenta`),
  KEY `fk_idventa_idx` (`idVenta`),
  KEY `fk_idproducto_idx` (`idProducto`),
  CONSTRAINT `fk_idproducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE,
  CONSTRAINT `fk_idventa` FOREIGN KEY (`idVenta`) REFERENCES `venta` (`idVenta`) ON DELETE CASCADE
)

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) 

CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
)

CREATE TABLE `usuarios_roles` (
  `usuario_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) 