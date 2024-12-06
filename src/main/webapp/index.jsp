<%@ page contentType="text/html" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard - Gestión de Tareas y Hábitos</title>
        <!--link rel="stylesheet" href="css/styles.css"-->

        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <!-- Barra de navegación -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow">
            <div class="container-fluid">
                <a class="navbar-brand fw-bold text-white" href="index.jsp">
                    <i class="bi bi-check2-circle me-2"></i>Gestión de Hábitos y Tareas
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link text-white fw-semibold" href="index.jsp">
                                <i class="bi bi-house-fill me-1"></i>Home
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white fw-semibold" href="javascript:void(0);" id="crearTareaLink">
                                <i class="bi bi-plus-circle me-1"></i>Nueva Tarea
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-white fw-semibold" href="javascript:void(0);" id="crearHabitoLink">
                                <i class="bi bi-journal-text me-1"></i>Nuevo Hábito
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-danger fw-semibold" href="LogoutServlet">
                                <i class="bi bi-box-arrow-right me-1"></i>Cerrar sesión
                            </a>
                        </li>
                    </ul>
                    <div class="d-flex align-items-center text-white">
                        <i class="bi bi-person-circle me-2"></i>
                        <span>¡Hola, <strong>${usuario.nombre}</strong>! Bienvenido de nuevo.</span>
                    </div>
                </div>
            </div>
        </nav>

        <main class="main-content">
            <div id="dashboardContent">
                <!--aqui va el contenido dinamico-->
            </div>

        </main>




        <!-- Scripts JS -->
        <script src="js/dashboard.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
