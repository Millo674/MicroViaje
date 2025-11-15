/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dto.ReservaDto;
import java.time.LocalDateTime;
import modelo.Reserva;
import persistencia.DaoFactory;
import persistencia.DaoReserva;

/**
 *
 * @author Camilo
 */
public class ReservaServicio {
    private final DaoReserva daoPostgres;

    public ReservaServicio() {
        this.daoPostgres = DaoFactory.getDaoFactory(DaoFactory.Posgres).getReservaDao();
    }
    public void registrarReserva (ReservaDto dto){
        
        Reserva r = new Reserva(dto.id, LocalDateTime.parse(dto.fechaReserva), dto.idViaje, dto.idpago, dto.idPasajero);
        daoPostgres.guardarReserva(r);
    }
    
    
}
