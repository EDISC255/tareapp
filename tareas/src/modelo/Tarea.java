/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author eduardo
 */
public class Tarea {
    private int id, status;
    private String titulo, desripcion, fechaRegistro, fechaAgendada;

    public Tarea() {
    }

    public Tarea(int id, int status, String titulo, String desripcion) {
        this.id = id;
        this.status = status;
        this.titulo = titulo;
        this.desripcion = desripcion;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaAgendada(String fechaAgendada) {
        this.fechaAgendada = fechaAgendada;
    }

    public String getFechaAgendada() {
        return fechaAgendada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesripcion() {
        return desripcion;
    }

    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
