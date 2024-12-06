/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.TareaDAO;
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
public class CompletarTareaServlet extends HttpServlet {

    private TareaDAO tareaDAO = new TareaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tareaId = Integer.parseInt(request.getParameter("id"));
        boolean success = tareaDAO.marcarComoCompletada(tareaId); // Método en DAO para actualizar estado

        response.setContentType("application/json");
        response.getWriter().write("{\"success\":" + success + "}");
    }
}
