/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.HabitoDAO;
import dao.TareaDAO;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Habito;
import model.Tarea;
import model.Usuario;

/**
 *
 * @author adani
 */
@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private final TareaDAO tareaDAO = new TareaDAO();
    private final HabitoDAO habitoDAO = new HabitoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el usuario de la sesión
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            //obtiene las metricas de los DAO
            int totalTareasCompletadas = tareaDAO.contarTareasCompletadasPorUsuario(usuario.getId());
            int frecuenciaHabitosSeguidos = habitoDAO.contarHabitosSeguidosPorUsuario(usuario.getId());
            //Envia los datos como atributos al JSP
            request.setAttribute("totalTareasCompletadas", totalTareasCompletadas);
            // Cargar tareas y hábitos activos
            List<Tarea> tareasActivas = tareaDAO.obtenerTareasPorEstado(usuario.getId(), "no completada");
            List<Habito> habitosActivos = habitoDAO.obtenerHabitosPorEstado(usuario.getId(), "activo");

            // Pasar datos al JSP
            request.setAttribute("tareasActivas", tareasActivas);
            request.setAttribute("habitosActivos", habitosActivos);

            // Redirigir al JSP del dashboard
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Error al obtener datos");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        String tipo = request.getParameter("tipo"); // tarea o habito
        long id = Long.parseLong(request.getParameter("id"));

        if ("marcarCompletado".equals(accion)) {
            if ("tarea".equals(tipo)) {
                tareaDAO.marcarComoCompletada(id);
            } else if ("habito".equals(tipo)) {
                habitoDAO.actualizarEstadoHabito(id);
            }
        } else if ("eliminar".equals(accion)) {
            if ("tarea".equals(tipo)) {
                tareaDAO.eliminarTarea(id);
            } else if ("habito".equals(tipo)) {
                habitoDAO.eliminarHabito(id);
            }
        }

        // Redirigir al dashboard
        response.sendRedirect("dashboard");

    }
}
