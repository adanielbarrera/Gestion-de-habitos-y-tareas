/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author adani
 */
public class Historial {
    private long id;
    private long tareaHabitoId;
    private long usuarioId;
    private LocalDateTime fechaRegistro;
    private String tipoAccion;

    // Constructor vacío
    public Historial() {}

    // Constructor completo
    public Historial(long id, long tareaHabitoId, long usuarioId, LocalDateTime fechaRegistro, String tipoAccion) {
        this.id = id;
        this.tareaHabitoId = tareaHabitoId;
        this.usuarioId = usuarioId;
        this.fechaRegistro = fechaRegistro;
        this.tipoAccion = tipoAccion;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTareaHabitoId() {
        return tareaHabitoId;
    }

    public void setTareaHabitoId(long tareaHabitoId) {
        this.tareaHabitoId = tareaHabitoId;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }
}
