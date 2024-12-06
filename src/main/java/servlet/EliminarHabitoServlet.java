/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.HabitoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author adani
 */
@WebServlet("/eliminarHabito")
public class EliminarHabitoServlet extends HttpServlet {

    private HabitoDAO habitoDAO = new HabitoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int habitoId = Integer.parseInt(request.getParameter("id"));
        boolean success = habitoDAO.eliminarHabito(habitoId); // Método en DAO para eliminar hábito

        response.setContentType("application/json");
        response.getWriter().write("{\"success\":" + success + "}");
    }
}
