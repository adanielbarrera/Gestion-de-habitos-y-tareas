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
import model.Usuario;

/**
 *
 * @author adani
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correoElectronico");
        String contrasena = request.getParameter("contrasena");
        // Validación de datos
        if (nombre != null && correo != null && contrasena != null) {
            Usuario usuario = new Usuario(0,nombre, correo, contrasena,null);
            boolean registrado = usuarioDAO.registrarUsuario(usuario);

            if (registrado) {
                // Redirigir a la página de login después de registrar
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("error", "Error en el registro. Intenta de nuevo.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                
                System.out.println("registrado "+usuario.getNombre());
            }
        } else {
            request.setAttribute("error", "Por favor, complete todos los campos.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
