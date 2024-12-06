/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author adani
 */
public class Estadistica {
    private long id;
    private long usuarioId;
    private String tipoMetrica;
    private double porcentajeProgreso;
    private int totalTareasCompletadas;
    private int frecuenciaHabitosSeguidos;

    // Constructor vacío
    public Estadistica() {}

    // Constructor completo
    public Estadistica(long id, long usuarioId, String tipoMetrica, double porcentajeProgreso, 
                        int totalTareasCompletadas, int frecuenciaHabitosSeguidos) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipoMetrica = tipoMetrica;
        this.porcentajeProgreso = porcentajeProgreso;
        this.totalTareasCompletadas = totalTareasCompletadas;
        this.frecuenciaHabitosSeguidos = frecuenciaHabitosSeguidos;
    }

    // Getters y Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTipoMetrica() {
        return tipoMetrica;
    }

    public void setTipoMetrica(String tipoMetrica) {
        this.tipoMetrica = tipoMetrica;
    }

    public double getPorcentajeProgreso() {
        return porcentajeProgreso;
    }

    public void setPorcentajeProgreso(double porcentajeProgreso) {
        this.porcentajeProgreso = porcentajeProgreso;
    }

    public int getTotalTareasCompletadas() {
        return totalTareasCompletadas;
    }

    public void setTotalTareasCompletadas(int totalTareasCompletadas) {
        this.totalTareasCompletadas = totalTareasCompletadas;
    }

    public int getFrecuenciaHabitosSeguidos() {
        return frecuenciaHabitosSeguidos;
    }

    public void setFrecuenciaHabitosSeguidos(int frecuenciaHabitosSeguidos) {
        this.frecuenciaHabitosSeguidos = frecuenciaHabitosSeguidos;
    }
}
