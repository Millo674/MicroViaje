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
import java.sql.*;
import java.util.ArrayList;
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

    @Override
    public Viaje buscarPorId(int id) {
        String sql = "SELECT * FROM viaje WHERE id = ?";

        try (PreparedStatement ps = bd.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Viaje(
                    rs.getInt("id"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getTimestamp("fecha_hora_viaje").toLocalDateTime(),
                    rs.getInt("id_vehiculos"),
                    rs.getInt("id_conductor")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error buscando viaje: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Viaje> listarTodos() {
        String sql = "SELECT * FROM viaje";
        List<Viaje> lista = new ArrayList<>();

        try (PreparedStatement ps = bd.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Viaje v = new Viaje(
                    rs.getInt("id"),
                    rs.getString("origen"),
                    rs.getString("destino"),
                    rs.getTimestamp("fecha_hora_viaje").toLocalDateTime(),
                    rs.getInt("id_vehiculos"),
                    rs.getInt("id_conductor")
                );
                lista.add(v);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listando viajes: " + e.getMessage(), e);
        }

        return lista;
    }
}
    

