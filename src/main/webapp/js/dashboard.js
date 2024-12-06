const basePath = `${window.location.protocol}//${window.location.host}/${window.location.pathname.split('/')[1]}`;

document.addEventListener("DOMContentLoaded", () => {
    cargarDashboard();
});

function cargarDashboard() {
    fetch(`${basePath}/DashboardServlet`, { method: 'GET' })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al obtener datos del servidor');
            }
            return response.text();
        })
        .then(data => {
            document.getElementById('dashboardContent').innerHTML = data;
            asignarEventosDashboard();
        })
        .catch(error => {
            console.error("Hubo un problema: ", error);
            document.getElementById('dashboardContent').innerHTML = "<p>Error al cargar el contenido.</p>";
        });
}

document.getElementById("crearTareaLink").addEventListener('click', () => {
    fetch(`${basePath}/crearTarea.jsp`, { method: 'GET' })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar la página de Crear Tarea');
            }
            return response.text();
        })
        .then(data => {
            document.getElementById('dashboardContent').innerHTML = data;
        })
        .catch(error => {
            console.error("Hubo un problema: ", error);
            document.getElementById("dashboardContent").innerHTML = "<p>Error al cargar</p>";
        });
});

document.getElementById("crearHabitoLink").addEventListener('click', () => {
    fetch(`${basePath}/crearHabito.jsp`, { method: 'GET' })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al cargar la página de Crear Hábito');
            }
            return response.text();
        })
        .then(data => {
            document.getElementById('dashboardContent').innerHTML = data;
        })
        .catch(error => {
            console.error("Hubo un problema: ", error);
            document.getElementById("dashboardContent").innerHTML = "<p>Error al cargar</p>";
        });
});

// Función para asignar eventos en el dashboard
function asignarEventosDashboard() {
    // Completar tarea
    document.querySelectorAll(".completarTareaBtn").forEach(button => {
        button.addEventListener("click", () => {
            const tareaId = button.getAttribute("data-id");
            fetch(`${basePath}/CompletarTareaServlet`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: `id=${tareaId}`
            })
                .then(response => response.json())
                .then(result => {
                    if (result.success) {
                        alert("Tarea completada con éxito");
                        cargarDashboard();
                    } else {
                        alert("Error al completar la tarea");
                    }
                })
                .catch(error => console.error("Error:", error));
        });
    });

    // Eliminar tarea
    document.querySelectorAll(".eliminarTareaBtn").forEach(button => {
        button.addEventListener("click", () => {
            const tareaId = button.getAttribute("data-id");
            fetch(`${basePath}/EliminarTareaServlet`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: `id=${tareaId}`
            })
                .then(response => response.json())
                .then(result => {
                    if (result.success) {
                        alert("Tarea eliminada con éxito");
                        cargarDashboard();
                    } else {
                        alert("Error al eliminar la tarea");
                    }
                })
                .catch(error => console.error("Error:", error));
        });
    });

    // Completar hábito
    document.querySelectorAll(".completarHabitoBtn").forEach(button => {
        button.addEventListener("click", () => {
            const habitoId = button.getAttribute("data-id");
            fetch(`${basePath}/CompletarHabitoServlet`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: `id=${habitoId}`
            })
                .then(response => response.json())
                .then(result => {
                    if (result.success) {
                        alert("Hábito completado con éxito");
                        cargarDashboard();
                    } else {
                        alert("Error al completar el hábito");
                    }
                })
                .catch(error => console.error("Error:", error));
        });
    });

    // Eliminar hábito
    document.querySelectorAll(".eliminarHabitoBtn").forEach(button => {
        button.addEventListener("click", () => {
            const habitoId = button.getAttribute("data-id");
            fetch(`${basePath}/EliminarHabitoServlet`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: `id=${habitoId}`
            })
                .then(response => response.json())
                .then(result => {
                    if (result.success) {
                        alert("Hábito eliminado con éxito");
                        cargarDashboard();
                    } else {
                        alert("Error al eliminar el hábito");
                    }
                })
                .catch(error => console.error("Error:", error));
        });
    });
}
