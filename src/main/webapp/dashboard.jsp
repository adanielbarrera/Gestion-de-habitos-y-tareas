<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container my-4">
    <div class="row mb-4">
        <div class="col text-center">
            <h2 class="display-5 text-primary">Resumen</h2>
        </div>
    </div>
    <div class="row">
        <!-- Resumen de estadísticas -->
        <div class="col-md-6 mb-3">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h3 class="card-title text-success">Estadísticas</h3>
                    <p class="card-text">
                        Tareas completadas: <strong>${totalTareasCompletadas}</strong>
                    </p>
                    <p class="card-text">
                        Hábitos seguidos: <strong>${frecuenciaHabitosSeguidos}</strong>
                    </p>
                </div>
            </div>
        </div>
        <!-- Tareas Activas -->
        <div class="col-md-6 mb-3">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h3 class="card-title text-info">Tareas Activas</h3>
                    <ul class="list-group">
                        <c:forEach var="tarea" items="${tareasActivas}">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <div>
                                    <strong>${tarea.titulo}</strong>
                                </div>
                                <div>
                                    <!-- Botones para acciones -->
                                    <button class="btn btn-success btn-sm me-2 completarTareaBtn" data-id="${tarea.id}">
                                        Listo
                                    </button>
                                    <button class="btn btn-warning btn-sm me-2 editarTarea" data-id="${tarea.id}">
                                        Editar
                                    </button>
                                    <button class="btn btn-danger btn-sm eliminarTareaBtn" data-id="${tarea.id}">
                                        Eliminar
                                    </button>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <!-- Hábitos Pendientes -->
        <div class="col-md-12">
            <div class="card shadow-sm">
                <div class="card-body">
                    <h3 class="card-title text-warning">Hábitos Pendientes</h3>
                    <ul class="list-group">
                        <c:forEach var="habito" items="${habitosActivos}">
                            <li class="list-group-item d-flex justify-content-between align-items-center">
                                <div>
                                    <strong>${habito.nombre}</strong> - 
                                    <span class="badge bg-warning text-dark">${habito.frecuencia}</span>
                                </div>
                                <div>
                                    <!-- Botones para acciones -->
                                    <button class="btn btn-success btn-sm me-2 completarHabitoBtn" data-id="${habito.id}">
                                        Marcar como completado
                                    </button>
                                    <button class="btn btn-warning btn-sm me-2 editarHabito" data-id="${habito.id}">
                                        Editar
                                    </button>
                                    <button class="btn btn-danger btn-sm eliminarHabitoBtn" data-id="${habito.id}">
                                        Eliminar
                                    </button>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
