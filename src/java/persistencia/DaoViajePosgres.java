/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import persistencia.DaoViaje;
import java.util.List;
import modelo.Viaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
/**
 *
 * @author Camilo
 */
public class DaoViajePosgres implements DaoViaje {
    
    private final Connection bd;

    public DaoViajePosgres(Connection bd) {
        this.bd = bd;
    }
    
    @Override
    public List<Viaje> listarviajes(int idconductor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void guardarViaje(Viaje viaje) {
        try {
            String sql = "INSERT INTO viaje(id, origen, destino, fecha_hora_viaje, id_vehiculo, id_conductor) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = bd.prepareStatement(sql);
            ps.setInt(1, viaje.getId());
            ps.setString(2, viaje.getOrigen());
            ps.setString(3, viaje.getDestino());
            ps.setTimestamp(4, Timestamp.valueOf(viaje.getFechaHoraViaje()));
            ps.setInt(5, viaje.getIdVehiculos());
            ps.setInt(6, viaje.getIdConductor());

            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }
}
    

