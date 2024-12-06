/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author adani
 */
import model.Tarea;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {

    // Método para crear una nueva tarea
    public boolean crearTarea(Tarea tarea) {
        String sql = "INSERT INTO tarea (usuario_id, titulo, descripcion, fecha_vencimiento, estado) VALUES (?, ?, ?, ?, ?)";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, tarea.getUsuarioId());
            statement.setString(2, tarea.getTitulo());
            statement.setString(3, tarea.getDescripcion());
            statement.setTimestamp(4, Timestamp.valueOf(tarea.getFechaVencimiento()));
            statement.setString(5, tarea.getEstado());

            return statement.executeUpdate() > 0; // Si se ejecuta con éxito, devuelve true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para obtener todas las tareas de un usuario
    public List<Tarea> obtenerTareasPorUsuario(long usuarioId) {
        List<Tarea> tareas = new ArrayList<>();
        String sql = "SELECT * FROM tarea WHERE usuario_id = ?";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, usuarioId);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tarea tarea = new Tarea(
                            resultSet.getLong("id"),
                            resultSet.getLong("usuario_id"),
                            resultSet.getString("titulo"),
                            resultSet.getString("descripcion"),
                            resultSet.getTimestamp("fecha_creacion").toLocalDateTime(),
                            resultSet.getTimestamp("fecha_vencimiento").toLocalDateTime(),
                            resultSet.getString("estado")
                    );
                    tareas.add(tarea);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareas;
    }

    // Método para actualizar el estado de una tarea
    public boolean actualizarEstadoTarea(long tareaId, String nuevoEstado) {
        String sql = "UPDATE tarea SET estado = ? WHERE id = ?";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nuevoEstado);
            statement.setLong(2, tareaId);

            return statement.executeUpdate() > 0; // Si se actualizó, devuelve true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar una tarea
    public boolean eliminarTarea(long tareaId) {
        String sql = "DELETE FROM tarea WHERE id = ?";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, tareaId);
            return statement.executeUpdate() > 0; // Si se eliminó, devuelve true
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Tarea> obtenerTareasPorEstado(long usuarioId, String estado) {
        String sql = "SELECT * FROM tarea WHERE usuario_id = ? AND estado = ?";
        List<Tarea> tareas = new ArrayList<>();
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, usuarioId);
            statement.setString(2, estado);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tarea tarea = new Tarea(
                            resultSet.getLong("id"),
                            resultSet.getLong("usuario_id"),
                            resultSet.getString("titulo"),
                            resultSet.getString("descripcion"),
                            resultSet.getTimestamp("fecha_creacion").toLocalDateTime(),
                            resultSet.getTimestamp("fecha_vencimiento") != null
                            ? resultSet.getTimestamp("fecha_vencimiento").toLocalDateTime() : null,
                            resultSet.getString("estado")
                    );
                    tareas.add(tarea);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tareas;
    }

    public boolean marcarComoCompletada(long id) {
        String sql = "UPDATE tarea SET estado = 'completada' WHERE id = ?";
        try ( Connection connection = DatabaseConnection.getConnection();  PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            return statement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int contarTareasCompletadasPorUsuario(long usuarioId){
        String sql ="SELECT COUNT(*) FROM tarea WHERE usuario_id = ? AND estado ='completada'";
        try(Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setLong(1, usuarioId);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    return resultSet.getInt(1); //retorna la cantidad de tareas completadas
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return 0;//si ocurre un error devuelve 0
    }

}
