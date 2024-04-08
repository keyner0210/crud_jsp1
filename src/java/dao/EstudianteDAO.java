/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {
    private Connection conexion;

    public EstudianteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean registrarEstudiante(Estudiante estudiante) {
        String sql = "INSERT INTO Estudiantes (semestre, carrera, universidad) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, estudiante.getSemestre());
            ps.setString(2, estudiante.getCarrera());
            ps.setString(3, estudiante.getUniversidad());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean editarEstudiante(Estudiante estudiante) {
        String sql = "UPDATE Estudiantes SET semestre=?, carrera=?, universidad=? WHERE usuario_id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, estudiante.getSemestre());
            ps.setString(2, estudiante.getCarrera());
            ps.setString(3, estudiante.getUniversidad());
            ps.setInt(4, estudiante.getUsuario_id());
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarEstudiante(int usuarioId) {
        String sql = "DELETE FROM Estudiantes WHERE usuario_id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Estudiante obtenerEstudiantePorId(int usuarioId) {
        String sql = "SELECT * FROM Estudiantes WHERE usuario_id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, usuarioId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Estudiante estudiante = new Estudiante();
                    estudiante.setUsuario_id(rs.getInt("usuario_id"));
                    estudiante.setSemestre(rs.getString("semestre"));
                    estudiante.setCarrera(rs.getString("carrera"));
                    estudiante.setUniversidad(rs.getString("universidad"));
                    return estudiante;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        String sql = "SELECT * FROM Estudiantes";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setUsuario_id(rs.getInt("usuario_id"));
                estudiante.setSemestre(rs.getString("semestre"));
                estudiante.setCarrera(rs.getString("carrera"));
                estudiante.setUniversidad(rs.getString("universidad"));
                estudiantes.add(estudiante);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return estudiantes;
    }
}