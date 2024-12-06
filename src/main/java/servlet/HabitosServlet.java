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
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import model.Habito;
import model.Usuario;

/**
 *
 * @author adani
 */
@WebServlet("/habitos")
public class HabitosServlet extends HttpServlet {

    private HabitoDAO habitoDAO = new HabitoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            List<Habito> habitos = habitoDAO.obtenerHabitosPorUsuario(usuario.getId());
            request.setAttribute("habitos", habitos);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String frecuencia = request.getParameter("frecuencia");
        String estado = request.getParameter("estado");

        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {

            LocalDateTime fechaInicio = LocalDateTime.now(); // Fecha actual

            Habito habito = new Habito(0, usuario.getId(), nombre, descripcion, frecuencia, fechaInicio, estado);
            boolean habitoCreado = habitoDAO.crearHabito(habito);

            if (habitoCreado) {
                response.sendRedirect("habitos");
            } else {
                request.setAttribute("error", "Error al crear el hábito.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
