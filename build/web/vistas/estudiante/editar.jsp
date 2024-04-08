<%-- 
    Document   : editar
    Created on : 7/04/2024, 1:24:35 a. m.
    Author     : POWER
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Estudiante</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 500px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        form {
            text-align: left;
        }
        input[type="text"],
        input[type="date"],
        input[type="email"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        select {
            height: 40px;
        }
        input[type="submit"],
        .btn-back {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none;
        }
        input[type="submit"]:hover,
        .btn-back:hover {
            background-color: #0056b3;
        }
        .error-message {
            color: red;
            font-size: 14px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Editar Estudiante</h1>
        <form action="controladorestudiante" method="post">
            <label for="id">Usuario_id:</label>
            <input type="text" usuario_id="usuario_id" name="usuario_id" value="${requestScope.estudiante.usuario_id}" readonly><br>
            <label for="semestre">Semestre:</label>
            <input type="text" usuario_id="Semestre" name="semestre" value="${requestScope.estudiante.semestre}" required><br>
            <label for="carrera">Carrera:</label>
            <input type="text" usuario_id="carrera" name="carrera" value="${requestScope.estudiante.carrera}" required><br>
            <label for="universidad">Universidad</label>
            <input type="text" usuario_id="universidad" name="universidad" value="${requestScope.estudiante.universidad}" required><br>
           
            <input type="hidden" name="accion" value="editar">
            <input type="submit" value="Editar">
        </form>
        <form action="index.jsp">
            <input type="submit" class="btn-back" value="Ir a Inicio">
        </form>
        <%-- Sección de mensajes de error --%>
        <div class="error-message">
            ${requestScope.error}
        </div>
    </div>
</body>
</html>

