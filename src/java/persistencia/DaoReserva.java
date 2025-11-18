/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import modelo.Reserva;

/**
 *
 * @author Camilo
 */
public interface DaoReserva {
    void guardarReserva (Reserva reserva);
    Reserva buscarPorId(int id);
    List<Reserva> listarTodos();
}
