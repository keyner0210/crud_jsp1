/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.conexionBD;
import dao.UsuarioDAO;
import modelo.Usuario;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorUsuario", urlPatterns = {"/usuario"})
public class controladorusuario extends HttpServlet {

    private final UsuarioDAO usuarioDAO;

    public controladorusuario() {
        super();
        usuarioDAO = new UsuarioDAO(conexionBD.getConnection());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "registrar":
                    mostrarFormularioRegistro(request, response);
                    break;
                case "listar":
                    listarUsuarios(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicion(request, response);
                    break;
                case "eliminar":
                    eliminarUsuario(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "registrar":
                    registrarUsuario(request, response);
                    break;
                case "editar":
                    editarUsuario(request, response);
                    break;
                default:
                    mostrarError(request, response, "Acción inválida");
            }
        } else {
            mostrarError(request, response, "Acción no especificada");
        }
    }

    private void mostrarFormularioRegistro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/vistas/usuario/registrar.jsp").forward(request, response);
    }

    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        String email = request.getParameter("email");
        String genero = request.getParameter("genero");
        String telefono = request.getParameter("telefono");

        // Validar campos (puedes agregar tus propias validaciones)

        try {
            java.util.Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoStr);
            Usuario usuario = new Usuario(0, clave, nombre, apellido, fechaNacimiento, email, genero, telefono);
            boolean registrado = usuarioDAO.registrarUsuario(usuario);

            if (registrado) {
                request.setAttribute("mensaje", "Usuario registrado correctamente");
                request.getRequestDispatcher("/vistas/usuario/registrar.jsp").forward(request, response);
            } else {
                mostrarError(request, response, "Error al registrar el usuario");
            }
        } catch (IllegalArgumentException ex) {
            mostrarError(request, response, "Fecha de nacimiento no válida");
        }
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
        String email = request.getParameter("email");
        String genero = request.getParameter("genero");
        String telefono = request.getParameter("telefono");

        // Validar campos (puedes agregar tus propias validaciones)

        try {
            java.util.Date fechaNacimiento = java.sql.Date.valueOf(fechaNacimientoStr);
            Usuario usuario = new Usuario(id, clave, nombre, apellido, fechaNacimiento, email, genero, telefono);
            boolean editado = usuarioDAO.editarUsuario(usuario);

            if (editado) {
                response.sendRedirect("usuario?accion=listar");
            } else {
                mostrarError(request, response, "Error al editar el usuario");
            }
        } catch (IllegalArgumentException ex) {
            mostrarError(request, response, "Fecha de nacimiento no válida");
        }
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean eliminado = usuarioDAO.eliminarUsuario(id);

        if (eliminado) {
            response.sendRedirect("usuario?accion=listar");
        } else {
            mostrarError(request, response, "Error al eliminar el usuario");
        }
    }

    private void listarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Usuario> usuarios = usuarioDAO.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("/vistas/usuario/listar.jsp").forward(request, response);
    }

    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("/vistas/error.jsp").forward(request, response);
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);
        request.setAttribute("usuario", usuario);
        request.getRequestDispatcher("/vistas/usuario/editar.jsp").forward(request, response);
    }
}
