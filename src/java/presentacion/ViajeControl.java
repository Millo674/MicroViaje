/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import com.google.gson.Gson;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servicio.ViajeServicio;
import dto.ViajeDto;
import java.io.BufferedReader;

@WebServlet("/viaje")
public class ViajeControl extends HttpServlet {

    private ViajeServicio servicio;

    @Override
    public void init() throws ServletException {
        super.init();
        servicio = new ViajeServicio();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");

        try {
            // Leer JSON enviado en el body
            BufferedReader reader = req.getReader();
            Gson gson = new Gson();
            ViajeDto dto = gson.fromJson(reader, ViajeDto.class);

            // Procesar viaje
            servicio.registrarViaje(dto);

            // Respuesta OK
            resp.getWriter().write("{\"mensaje\": \"Viaje registrado correctamente\"}");

        } catch (Exception e) {
            resp.setStatus(500);
            resp.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}



