/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (clave, nombre, apellido, fechaNacimiento, email, genero, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getClave());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getGenero());
            ps.setString(7, usuario.getTelefono());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean editarUsuario(Usuario usuario) {
        String sql = "UPDATE Usuarios SET clave=?, nombre=?, apellido=?, fechaNacimiento=?, email=?, genero=?, telefono=? WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario.getClave());
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getApellido());
            ps.setDate(4, new java.sql.Date(usuario.getFechaNacimiento().getTime()));
            ps.setString(5, usuario.getEmail());
            ps.setString(6, usuario.getGenero());
            ps.setString(7, usuario.getTelefono());     
            ps.setInt(8, usuario.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM Usuarios WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        String sql = "SELECT * FROM Usuarios WHERE id=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setClave(rs.getString("clave"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setGenero(rs.getString("genero"));
                    usuario.setTelefono(rs.getString("telefono"));
                    return usuario;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuarios";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setClave(rs.getString("clave"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                usuario.setEmail(rs.getString("email"));
                usuario.setGenero(rs.getString("genero"));
                usuario.setTelefono(rs.getString("telefono"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    } 
}

