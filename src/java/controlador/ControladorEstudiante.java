/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.EstudianteDAO;
import modelo.Estudiante;
import dao.conexionBD;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "controladorestudiante", urlPatterns = {"/estudiante"})
public class controladorestudiante extends HttpServlet {

    private EstudianteDAO estudianteDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        estudianteDAO = new EstudianteDAO(conexionBD.getConnection());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "agregar":
                    mostrarFormularioRegistro(request, response);
                    break;
                case "listar":
                    listarEstudiantes(request, response);
                    break;
                case "editar":
                    mostrarFormularioEdicion(request, response);
                    break;
                case "eliminar":
                    eliminarEstudiante(request, response);
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
                case "agregar":
                    agregarEstudiante(request, response);
                    break;
                case "editar":
                    editarEstudiante(request, response);
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
        request.getRequestDispatcher("/vistas/estudiante/agregar.jsp").forward(request, response);
    }

    private void agregarEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Estudiante estudiante = extraerDatosEstudiante(request);
        boolean agregado = estudianteDAO.registrarEstudiante(estudiante);
        if (agregado) {
            request.setAttribute("mensaje", "Estudiante agregado exitosamente");
            listarEstudiantes(request, response);
        } else {
            mostrarError(request, response, "Error al agregar el estudiante");
        }
    }

    private Estudiante extraerDatosEstudiante(HttpServletRequest request) throws ServletException, IOException {
        String semestre = request.getParameter("semestre");
        String carrera = request.getParameter("carrera");
        String universidad = request.getParameter("universidad");

        Estudiante estudiante = new Estudiante();
        estudiante.setSemestre(semestre);
        estudiante.setCarrera(carrera);
        estudiante.setUniversidad(universidad);

        return estudiante;
    }

    private void editarEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Estudiante estudiante = extraerDatosEstudiante(request);
        estudiante.setUsuario_id(Integer.parseInt(request.getParameter("usuario_id")));
        boolean editado = estudianteDAO.editarEstudiante(estudiante);
        if (editado) {
            listarEstudiantes(request, response);
        } else {
            mostrarError(request, response, "Error al editar el estudiante");
        }
    }

    private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int usuario_id = Integer.parseInt(request.getParameter("usuario_id"));
        boolean eliminado = estudianteDAO.eliminarEstudiante(usuario_id);
        if (eliminado) {
            listarEstudiantes(request, response);
        } else {
            mostrarError(request, response, "Error al eliminar el estudiante");
        }
    }

    private void listarEstudiantes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Estudiante> estudiantes = estudianteDAO.listarEstudiantes();
        request.setAttribute("estudiantes", estudiantes);
        request.getRequestDispatcher("/vistas/estudiante/listar.jsp").forward(request, response);
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int usuario_id = Integer.parseInt(request.getParameter("usuario_id"));
        Estudiante estudiante = estudianteDAO.obtenerEstudiantePorId(usuario_id);
        request.setAttribute("estudiante", estudiante);
        request.getRequestDispatcher("/vistas/estudiante/editar.jsp").forward(request, response);
    }

    private void mostrarError(HttpServletRequest request, HttpServletResponse response, String mensaje)
            throws ServletException, IOException {
        request.setAttribute("error", mensaje);
        request.getRequestDispatcher("/vistas/error.jsp").forward(request, response);
    }
}
