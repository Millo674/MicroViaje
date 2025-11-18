/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dto.ReservaDto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;
import modelo.Viaje;
import persistencia.DaoFactory;
import persistencia.DaoReserva;
import persistencia.DaoViaje;

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
    public List<ReservaDto> listarReservas() {

        List<Reserva> lista = daoPostgres.listarTodos();
        List<ReservaDto> respuesta = new ArrayList<>();

        for (Reserva r : lista) {
            ReservaDto dto = new ReservaDto();
            dto.id = r.getId();
            dto.fechaReserva = r.getFechaReserva().toString();
            dto.idViaje = r.getIdViaje();
            dto.idpago = r.getIdpago();
            dto.idPasajero = r.getIdPasajero();

            respuesta.add(dto);
        }

        return respuesta;
    }

    // ------------------ BUSCAR UNO ------------------
    public ReservaDto buscarReserva(int id) {

        Reserva r = daoPostgres.buscarPorId(id);

        if (r == null) {
            return null;
        }

        ReservaDto dto = new ReservaDto();
        dto.id = r.getId();
        dto.fechaReserva = r.getFechaReserva().toString();
        dto.idViaje = r.getIdViaje();
        dto.idpago = r.getIdpago();
        dto.idPasajero = r.getIdPasajero();

        return dto;
    }
    
}
