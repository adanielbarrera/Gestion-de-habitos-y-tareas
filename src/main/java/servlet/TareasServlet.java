/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.TareaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import model.Tarea;
import model.Usuario;

/**
 *
 * @author adani
 */
@WebServlet("/tareas")
public class TareasServlet extends HttpServlet {

    private TareaDAO tareaDAO = new TareaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            List<Tarea> tareas = tareaDAO.obtenerTareasPorUsuario(usuario.getId());
            request.setAttribute("tareas", tareas);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String fechaVencimientoStr = request.getParameter("fechaVencimiento");
        String estado = request.getParameter("estado");

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
                    request.setAttribute("error", "Formato de fecha inválido. Usa: 'yyyy-MM-dd HH:mm'.");
                    request.getRequestDispatcher("/tareas.jsp").forward(request, response);
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
}
