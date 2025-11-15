/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;
import java.util.List;


/**
 *
 * @author Camilo
 */
public class Viaje {
    private int id;
    private String origen;
    private String destino;
    private LocalDateTime fechaHoraViaje;
    private int idVehiculos;
    private int idConductor;

    public Viaje(int id, String origen, String destino, LocalDateTime fechaHoraViaje, int idVehiculos, int idConductor) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaHoraViaje = fechaHoraViaje;
        this.idVehiculos = idVehiculos;
        this.idConductor = idConductor;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the fechaHoraViaje
     */
    public LocalDateTime getFechaHoraViaje() {
        return fechaHoraViaje;
    }

    /**
     * @param fechaHoraViaje the fechaHoraViaje to set
     */
    public void setFechaHoraViaje(LocalDateTime fechaHoraViaje) {
        this.fechaHoraViaje = fechaHoraViaje;
    }

    /**
     * @return the idVhehiculos
     */
    public int getIdVehiculos() {
        return idVehiculos;
    }

    /**
     * @param idVehiculos the idVehiculos to set
     */
    public void setIdVehiculos(int idVehiculos) {
        this.idVehiculos = idVehiculos;
    }

    /**
     * @return the idConductor
     */
    public int getIdConductor() {
        return idConductor;
    }

    /**
     * @param idConductor the idConductor to set
     */
    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }
    
}
