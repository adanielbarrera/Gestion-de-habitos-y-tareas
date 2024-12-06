/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author adani
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import model.Usuario;
import util.DatabaseConnection;

public class UsuarioDAO {
    // Método para registrar un usuario
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, correo_electronico, contrasena) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getCorreoElectronico());
            statement.setString(3, usuario.getContrasena());

            return statement.executeUpdate() > 0; // Si se ejecuta con éxito, devuelve true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar un usuario por correo electrónico
    public Optional<Usuario> buscarPorCorreo(String correoElectronico) {
        String sql = "SELECT * FROM usuario WHERE correo_electronico = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, correoElectronico);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Usuario usuario = new Usuario(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo_electronico"),
                        resultSet.getString("contrasena"),
                        resultSet.getTimestamp("fecha_registro").toLocalDateTime()
                    );
                    return Optional.of(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty(); // Si no se encuentra, regresa vacío
    }

    // Método para autenticar un usuario
    public boolean autenticarUsuario(String correoElectronico, String contrasena) {
        String sql = "SELECT * FROM usuario WHERE correo_electronico = ? AND contrasena = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, correoElectronico);
            statement.setString(2, contrasena);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Si encuentra una fila, autenticación exitosa
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
