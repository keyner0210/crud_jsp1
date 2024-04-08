<%-- 
    Document   : index
    Created on : 7/04/2024, 3:16:26 a. m.
    Author     : POWER
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido a tu Aplicación</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        p {
            color: #666;
            margin-bottom: 20px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bienvenido a tu Aplicación</h1>
        <p>Esta es una aplicación web para consultar semestre del usuario.</p>
        <a href="usuario?accion=registrar" class="btn">Registrar Nuevo Usuario</a>
        <a href="usuario?accion=listar" class="btn">Listar Usuarios</a>
        <a href="estudiante?accion=agregar" class="btn">Agregar Nuevos Estudiantes</a>
        <a href="estudiante?accion=listar" class="btn">Listar Estudiantes</a>
    </div>
</body>
</html>
