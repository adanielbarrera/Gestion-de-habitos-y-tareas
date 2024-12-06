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
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import model.Tarea;
import model.Usuario;

/**
 *
 * @author adani
 */
public class TestServlet extends HttpServlet {

    private TareaDAO tareaDAO = new TareaDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String fechaVencimientoStr = request.getParameter("fechaVencimiento");
        String estado = request.getParameter("estado");
        fechaVencimientoStr = fechaVencimientoStr.replace("T"," ");
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            LocalDateTime fechaVencimiento = null;
            if (fechaVencimientoStr != null && !fechaVencimientoStr.isEmpty()) {
                try {
                    // Define el formato que esperas recibir en el parámetro
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    fechaVencimiento = LocalDateTime.parse(fechaVencimientoStr, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("error"+ "Formato de fecha inválido. Usa: 'yyyy-MM-dd HH:mm'."+fechaVencimientoStr);
                    request.getRequestDispatcher("/tareas").forward(request, response);
                    return;
                }
            }
            Tarea tarea = new Tarea(0, usuario.getId(), titulo, descripcion, null, fechaVencimiento, estado);
            boolean tareaCreada = tareaDAO.crearTarea(tarea);

            if (tareaCreada) {
                response.sendRedirect("tareas");
            } else {
                request.setAttribute("error", "Error al crear la tarea.");
                request.getRequestDispatcher("/tareas.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().write("¡funciona!");
    }
}
