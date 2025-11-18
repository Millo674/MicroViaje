/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dto.ViajeDto;
import java.time.LocalDateTime;
import java.util.List;
import modelo.Viaje;
import persistencia.DaoFactory;
import persistencia.DaoViaje;

/**
 *
 * @author Camilo
 */
public class ViajeServicio {
    private final DaoViaje daoPostgres;
    
    public ViajeServicio(){
        daoPostgres = DaoFactory.getDaoFactory(DaoFactory.Posgres).getViajeDao();
    }
    public void registrarViaje(ViajeDto dto) {

        Viaje v = new Viaje(
            dto.id,
            dto.origen,
            dto.destino,
                LocalDateTime.parse(dto.fechaHoraViaje),
            dto.idVehiculos,
            dto.idConductor
        );

        daoPostgres.guardarViaje(v);
    }
    
    public Viaje BuscarViaje(int id){
        return daoPostgres.buscarPorId(id);
    }
    public List<Viaje> listarViaje(){
        return daoPostgres.listarTodos();
    }
}
