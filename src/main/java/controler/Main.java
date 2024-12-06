/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author adani
 */
public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Crear un nuevo usuario
        Usuario usuario = new Usuario(0, "Daniel", "daniel@example.com", "password123", null);
        if (usuarioDAO.registrarUsuario(usuario)) {
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("Error al registrar usuario.");
        }

        // Buscar por correo
        usuarioDAO.buscarPorCorreo("daniel@example.com").ifPresentOrElse(
            u -> System.out.println("Usuario encontrado: " + u.getNombre()),
            () -> System.out.println("Usuario no encontrado.")
        );

        // Autenticación
        if (usuarioDAO.autenticarUsuario("daniel@example.com", "password123")) {
            System.out.println("Autenticación exitosa.");
        } else {
            System.out.println("Credenciales incorrectas.");
        }
    }
}
