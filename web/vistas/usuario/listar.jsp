<%-- 
    Document   : listar
    Created on : 7/04/2024, 1:23:54 a. m.
    Author     : POWER
--%>
<%@page import="java.util.List"%>
<%@page import="modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Usuarios</title>
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
    </style>
</head>
<body>
    <div class="container">
        <h1>Listado de usuarios</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Clave</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Fecha de Nacimiento</th>
                    <th>Email</th>
                    <th>Género</th>
                    <th>Teléfono</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                    for (Usuario usuario : usuarios) {
                %>
                <tr>
                    <td><%= usuario.getId() %></td>
                    <td><%= usuario.getClave() %></td>
                    <td><%= usuario.getNombre() %></td>
                    <td><%= usuario.getApellido() %></td>
                    <td><%= usuario.getFechaNacimiento() %></td>
                    <td><%= usuario.getEmail() %></td>
                    <td><%= usuario.getGenero() %></td>
                    <td><%= usuario.getTelefono() %></td>
                    <td>
                        <a href="usuario?accion=editar&id=<%= usuario.getId() %>" class="btn-edit">Editar</a>
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
