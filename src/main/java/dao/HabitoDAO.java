/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author adani
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Habito;
import util.DatabaseConnection;

public class HabitoDAO {

    // Método para crear un nuevo hábito
    public boolean crearHabito(Habito habito) {
        String sql = "INSERT INTO habito (usuario_id, nombre, descripcion, frecuencia, estado) VALUES (?, ?, ?, ?, ?)";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, habito.getUsuarioId());
            statement.setString(2, habito.getNombre());
            statement.setString(3, habito.getDescripcion());
            statement.setString(4, habito.getFrecuencia());
            statement.setString(5, habito.getEstado());

            return statement.executeUpdate() > 0; // Si se ejecuta con éxito, devuelve true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todos los hábitos de un usuario
    public List<Habito> obtenerHabitosPorUsuario(long usuarioId) {
        List<Habito> habitos = new ArrayList<>();
        String sql = "SELECT * FROM habito WHERE usuario_id = ?";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, usuarioId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Habito habito = new Habito(
                            resultSet.getLong("id"),
                            resultSet.getLong("usuario_id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("descripcion"),
                            resultSet.getString("frecuencia"),
                            resultSet.getTimestamp("fecha_inicio").toLocalDateTime(),
                            resultSet.getString("estado")
                    );
                    habitos.add(habito);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habitos;
    }

    // Método para actualizar el estado de un hábito
    public boolean actualizarEstadoHabito(long habitoId) {
        String sql = "UPDATE habito SET estado = 'inactivo' WHERE id = ?";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, habitoId);

            return statement.executeUpdate() > 0; // Si se actualizó, devuelve true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un hábito
    public boolean eliminarHabito(long habitoId) {
        String sql = "DELETE FROM habito WHERE id = ?";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, habitoId);
            return statement.executeUpdate() > 0; // Si se eliminó, devuelve true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Habito> obtenerHabitosPorEstado(long usuarioId, String estado) {
        String sql = "SELECT * FROM habito WHERE usuario_id = ? AND estado = ?";
        List<Habito> habitos = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, usuarioId);
            statement.setString(2, estado);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Habito habito = new Habito(
                            resultSet.getLong("id"),
                            resultSet.getLong("usuario_id"),
                            resultSet.getString("nombre"),
                            resultSet.getString("descripcion"),
                            resultSet.getString("frecuencia"),
                            resultSet.getTimestamp("fecha_inicio").toLocalDateTime(),
                            resultSet.getString("estado")
                    );
                    habitos.add(habito);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return habitos;
    }
    
    public int contarHabitosSeguidosPorUsuario(long usuarioId){
        String sql = "SELECT SUM(frecuencia_habitos_seguidos) FROM estadisticas WHERE usuario_id = ? AND tipo_metrica = 'habito'";
        try(Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1,usuarioId);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    return resultSet.getInt(1);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
