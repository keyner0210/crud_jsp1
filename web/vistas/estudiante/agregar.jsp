<%-- 
    Document   : agregar
    Created on : 7/04/2024, 1:24:28 a. m.
    Author     : POWER
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Agregar Estudiante</title>
</head>
<body>
    <h1>Agregar Estudiante</h1>
    <form action="estudiante" method="post">
        <label for="usuario_id">ID del Usuario:</label><br>
        <input type="text" id="usuario_id" name="usuario_id" required><br><br>
        
        <label for="semestre">Semestre:</label><br>
        <input type="text" id="semestre" name="semestre" required><br><br>
        
        <label for="carrera">Carrera:</label><br>
        <input type="text" id="carrera" name="carrera" required><br><br>
        
        <label for="universidad">Universidad:</label><br>
        <input type="text" id="universidad" name="universidad" required><br><br>
        
        <input type="submit" value="Agregar Estudiante">
    </form>
</body>
</html>