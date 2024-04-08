<%-- 
    Document   : editar
    Created on : 7/04/2024, 1:23:44?a. m.
    Author     : POWER
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
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
        <h1>Editar Usuario</h1>
        <form action="controladorusuario" method="post">
            <label for="id">ID:</label>
            <input type="text" id="id" name="id" value="${requestScope.usuario.id}" readonly><br>
            <label for="clave">Clave:</label>
            <input type="text" id="clave" name="clave" value="${requestScope.usuario.clave}" required><br>
            <label for="nombre">Nombre:</label>
            <input type="text" id="nombre" name="nombre" value="${requestScope.usuario.nombre}" required><br>
            <label for="apellido">Apellido:</label>
            <input type="text" id="apellido" name="apellido" value="${requestScope.usuario.apellido}" required><br>
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="date" id="fechaNacimiento" name="fechaNacimiento" value="${requestScope.usuario.fechaNacimiento}" required><br>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${requestScope.usuario.email}" required><br>
            <label for="genero">Género:</label>
            <select id="genero" name="genero" required>
                <option value="">Seleccionar</option>
                <option value="Masculino" ${requestScope.usuario.genero.equals("Masculino") ? "selected" : ""}>Masculino</option>
                <option value="Femenino" ${requestScope.usuario.genero.equals("Femenino") ? "selected" : ""}>Femenino</option>
            </select><br>
            <label for="telefono">Teléfono:</label>
            <input type="text" id="telefono" name="telefono" value="${requestScope.usuario.telefono}" required><br>
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

