/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.HabitoDAO;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author adani
 */
@WebServlet("/completarHabito")
public class CompletarHabitoServlet extends HttpServlet {
private HabitoDAO habitoDAO = new HabitoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            // Obtener el ID del hábito desde la solicitud
            long habitoId = Long.parseLong(request.getParameter("id"));

            // Actualizar el estado del hábito en la base de datos
            boolean success = habitoDAO.actualizarEstadoHabito(habitoId);

            // Enviar la respuesta como JSON
            out.print("{\"success\": " + success + "}");
        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"success\": false}");
        }
    }
}
