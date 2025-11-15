/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author Camilo
 */
public abstract class DaoFactory {
    public static final int Posgres = 1;
    public static final int Mongodb = 2;
    
    public abstract DaoViaje getViajeDao();
    
    public static DaoFactory getDaoFactory(int tipoBD){
        switch (tipoBD) {
            case Posgres:
                return new DaoposgresFactory();
            default:
                throw new IllegalArgumentException("Tipo de BD no soportado: " + tipoBD);
        }
    }
}
