/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import modelo.Viaje;

/**
 *
 * @author Camilo
 */
public interface DaoViaje {
    void guardarViaje(Viaje viaje);
     Viaje buscarPorId(int id);
    List<Viaje> listarTodos();
}
