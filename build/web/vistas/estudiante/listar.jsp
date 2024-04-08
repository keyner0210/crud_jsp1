<%-- 
    Document   : listar
    Created on : 7/04/2024, 1:24:42 a. m.
    Author     : POWER
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.estudiante"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Estudiantes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
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
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn-back {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none;
        }
        .btn-back:hover {
            background-color: #0056b3;
        }
        .btn-edit, .btn-delete {
            display: inline-block;
            margin-right: 5px;
            background-color: #28a745;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 5px 10px;
            text-decoration: none;
        }
        .btn-delete {
            background-color: #dc3545;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Listado de Estudiantes</h1>
        <table>
            <thead>
                <tr>
                    <th>Usuario ID</th>
                    <th>Semestre</th>
                    <th>Carrera</th>
                    <th>Universidad</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<estudiante> estudiantes = (List<estudiante>) request.getAttribute("estudiantes");
                    for (estudiante estudiante : estudiantes) {
                %>
                <tr>
                    <td><%= estudiante.getusuario_id() %></td>
                    <td><%= estudiante.getsemestre() %></td>
                    <td><%= estudiante.getcarrera() %></td>
                    <td><%= estudiante.getuniversidad() %></td>
                    <td>
                        <a href="estudiante?accion=editar&id=<%= estudiante.getusuario_id() %>" class="btn-edit">Editar</a>
                        <a href="estudiante?accion=eliminar&id=<%= estudiante.getusuario_id() %>" class="btn-delete">Eliminar</a>
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <form action="index.jsp">
            <input type="submit" class="btn-back" value="Ir a Inicio">
        </form>
    </div>
</body>
</html>
