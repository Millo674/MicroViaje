/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import modelo.Reserva;

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
    
}
