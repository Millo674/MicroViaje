/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Camilo
 */
public class DaoposgresFactory extends DaoFactory{
    
    private Connection bd;
    
    public DaoposgresFactory(){
        try{
            Class.forName("org.postgresql.Driver");
            bd = DriverManager.getConnection(
               "jdbc:postgresql://localhost:5432/viajeReserva",
               "postgres",
               "123456"
            );
        }catch (ClassNotFoundException | SQLException e) {
        }
    }

    @Override
    public DaoViaje getViajeDao() {
        return new DaoViajePosgres(bd);
    }
    
}
