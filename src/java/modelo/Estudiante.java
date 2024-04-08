/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Estudiante {
    private int usuario_id;
    private String semestre;
    private String carrera;
    private String universidad;

    public Estudiante() {
    }

    public Estudiante(int usuario_id, String semestre, String carrera, String universidad) {
        this.usuario_id = usuario_id;
        this.semestre = semestre;
        this.carrera = carrera;
        this.universidad = universidad;
    }

    // Getters y Setters

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
}
   