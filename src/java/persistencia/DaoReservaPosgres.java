/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;
import java.sql.*;

/**
 *
 * @author Camilo
 */
public class DaoReservaPosgres implements DaoReserva{

    private final Connection bd;

    public DaoReservaPosgres(Connection bd) {
        this.bd = bd;
    }
    
    
    @Override
    public void guardarReserva(Reserva reserva) {
        try{
            String sql = "INSERT INTO reserva(id, fechaReserva, idviaje, idpago, idpsajero) "
                       + "VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement ps = bd.prepareStatement(sql);
            ps.setInt(1, reserva.getId());
            ps.setTimestamp(2, Timestamp.valueOf(reserva.getFechaReserva()));
            ps.setInt(3, reserva.getIdViaje());
            ps.setInt(4, reserva.getIdpago());
            ps.setInt(5, reserva.getIdPasajero());
            
            ps.executeUpdate();
        }catch(SQLException e){
            
        }
    }
     @Override
    public Reserva buscarPorId(int id) {
        String sql = "SELECT * FROM reserva WHERE id = ?";

        try (PreparedStatement ps = bd.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Reserva(
                    rs.getInt("id"),
                    rs.getTimestamp("fecha_reserva").toLocalDateTime(),
                    rs.getInt("id_viaje"),
                    rs.getInt("id_pago"),
                    rs.getInt("id_pasajero")
                );
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error buscando reserva: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Reserva> listarTodos() {
        String sql = "SELECT * FROM reserva";
        List<Reserva> lista = new ArrayList<>();

        try (PreparedStatement ps = bd.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva(
                    rs.getInt("id"),
                    rs.getTimestamp("fecha_reserva").toLocalDateTime(),
                    rs.getInt("id_viaje"),
                    rs.getInt("id_pago"),
                    rs.getInt("id_pasajero")
                );
                lista.add(r);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error listando reservas: " + e.getMessage(), e);
        }

        return lista;
    }
    
}
