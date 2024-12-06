/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import model.Usuario;

/**
 *
 * @author adani
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        System.out.println("correo: "+correo+" Contraseña: "+contrasena);

        if (correo != null && contrasena != null) {
            Optional<Usuario> usuarioOpt = usuarioDAO.buscarPorCorreo(correo);

            if (usuarioOpt.isPresent() && usuarioOpt.get().getContrasena().equals(contrasena)) {
                // Guardar sesión del usuario
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuarioOpt.get());

                // Redirigir al panel principal
                response.sendRedirect("index.jsp");
            } else {
                request.setAttribute("error", "Credenciales incorrectas.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error", "Por favor, complete todos los campos.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
