<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <title>Crear Tarea</title>
</head>
<body class="bg-light">
    <div class="container py-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-lg">
                    <div class="card-body">
                        <h2 class="card-title text-center text-primary mb-4">Nueva Tarea</h2>
                        <form id="formCrearTarea" action="${pageContext.request.contextPath}/TestServlet" method="POST">
                            <!-- Título -->
                            <div class="mb-3">
                                <label for="titulo" class="form-label">Título:</label>
                                <input type="text" id="titulo" name="titulo" class="form-control" placeholder="Escribe el título" required>
                            </div>
                            <!-- Descripción -->
                            <div class="mb-3">
                                <label for="descripcion" class="form-label">Descripción:</label>
                                <textarea id="descripcion" name="descripcion" class="form-control" rows="4" placeholder="Agrega una descripción"></textarea>
                            </div>
                            <!-- Fecha de Vencimiento -->
                            <div class="mb-3">
                                <label for="fechaVencimiento" class="form-label">Fecha de vencimiento:</label>
                                <input type="datetime-local" id="fechaVencimiento" name="fechaVencimiento" class="form-control" required>
                            </div>
                            <!-- Estado -->
                            <div class="mb-3">
                                <label for="estado" class="form-label">Estado:</label>
                                <select id="estado" name="estado" class="form-select">
                                    <option value="no completada">No completada</option>
                                    <option value="completada">Completada</option>
                                </select>
                            </div>
                            <!-- Botón de Enviar -->
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary">Crear Tarea</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

