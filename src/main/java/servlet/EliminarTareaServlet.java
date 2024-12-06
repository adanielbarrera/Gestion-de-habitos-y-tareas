/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.TareaDAO;
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
@WebServlet("/eliminarTarea")
public class EliminarTareaServlet extends HttpServlet {

    private TareaDAO tareaDAO = new TareaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tareaId = Integer.parseInt(request.getParameter("id"));
        boolean success = tareaDAO.eliminarTarea(tareaId); // Método en DAO para eliminar tarea

        response.setContentType("application/json");
        response.getWriter().write("{\"success\":" + success + "}");
    }
}
