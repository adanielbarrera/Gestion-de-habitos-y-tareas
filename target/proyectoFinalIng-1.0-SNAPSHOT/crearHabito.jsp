<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Hábito</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Fuente Roboto -->
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background: #fff;
            border-radius: 15px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .form-container h2 {
            color: #0d6efd;
            font-weight: 500;
            text-align: center;
            margin-bottom: 20px;
        }
        button[type="submit"] {
            background-color: #0d6efd;
            border-color: #0d6efd;
        }
        button[type="submit"]:hover {
            background-color: #0a58ca;
            border-color: #0a58ca;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Nuevo Hábito</h2>
        <form id="formCrearHabito" action="${pageContext.request.contextPath}/HabitosServlet" method="POST">
            <!-- Input de nombre -->
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre:</label>
                <input type="text" id="nombre" name="nombre" class="form-control" placeholder="Escribe el nombre del hábito" required>
            </div>
            <!-- Input de descripción -->
            <div class="mb-3">
                <label for="descripcion" class="form-label">Descripción:</label>
                <textarea id="descripcion" name="descripcion" class="form-control" rows="3" placeholder="Describe el hábito (opcional)"></textarea>
            </div>
            <!-- Selección de frecuencia -->
            <div class="mb-3">
                <label for="frecuencia" class="form-label">Frecuencia:</label>
                <select id="frecuencia" name="frecuencia" class="form-select">
                    <option value="diario">Diario</option>
                    <option value="semanal">Semanal</option>
                    <option value="mensual">Mensual</option>
                </select>
            </div>
            <!-- Selección de estado -->
            <div class="mb-3">
                <label for="estado" class="form-label">Estado:</label>
                <select id="estado" name="estado" class="form-select">
                    <option value="activo">Activo</option>
                    <option value="inactivo">Inactivo</option>
                </select>
            </div>
            <!-- Botón de envío -->
            <button type="submit" class="btn btn-primary w-100">Crear Hábito</button>
        </form>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>