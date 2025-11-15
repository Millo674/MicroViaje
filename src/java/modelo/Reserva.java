/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Camilo
 */
public class Reserva {
    private int id;
    private LocalDateTime fechaReserva;
    private int idViaje;
    private int idpago;
    private int idPasajero;

    public Reserva(int id, LocalDateTime fechaReserva, int idViaje, int idpago, int idPasajero) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.idViaje = idViaje;
        this.idpago = idpago;
        this.idPasajero = idPasajero;
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
     * @return the fechaReserva
     */
    public LocalDateTime getFechaReserva() {
        return fechaReserva;
    }

    /**
     * @param fechaReserva the fechaReserva to set
     */
    public void setFechaReserva(LocalDateTime fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * @return the idViaje
     */
    public int getIdViaje() {
        return idViaje;
    }

    /**
     * @param idViaje the idViaje to set
     */
    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    /**
     * @return the idpago
     */
    public int getIdpago() {
        return idpago;
    }

    /**
     * @param idpago the idpago to set
     */
    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    /**
     * @return the idPasajero
     */
    public int getIdPasajero() {
        return idPasajero;
    }

    /**
     * @param idPasajero the idPasajero to set
     */
    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }
    
}
