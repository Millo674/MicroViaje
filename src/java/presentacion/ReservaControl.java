/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import com.google.gson.Gson;
import dto.ReservaDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import servicio.ReservaServicio;

/**
 *
 * @author Camilo
 */
@WebServlet("/reserva")
public class ReservaControl extends HttpServlet{
    
    private ReservaServicio servicio;
    
    @Override
    public void init() throws ServletException{
        super.init();
        servicio = new ReservaServicio();
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        resp.setContentType("application/json");
        try{
            BufferedReader reader = req.getReader();
            Gson gson = new Gson();
            ReservaDto dto =gson.fromJson(reader, ReservaDto.class);
            
            servicio.registrarReserva(dto);
            
            resp.getWriter().write("{\"mensaje\": \"Viaje registrado correctamente\"}");
            
        }catch(Exception e){
            resp.setStatus(500);
            resp.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        String path = req.getPathInfo();

        try {
            // /reserva/listar
            if ("/listar".equals(path)) {
                List<ReservaDto> lista = servicio.listarReservas();
                resp.getWriter().write(new Gson().toJson(lista));
                return;
            }

            // /reserva?id=1
            String idStr = req.getParameter("id");
            if (idStr != null) {
                int id = Integer.parseInt(idStr);
                ReservaDto dto = servicio.buscarReserva(id);
                resp.getWriter().write(new Gson().toJson(dto));
            } else {
                resp.setStatus(400);
                resp.getWriter().write("{\"error\":\"Debe enviar el parámetro id\"}");
            }

        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}
