
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login / Registro</title>
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Fuente Roboto -->
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
        <style>
            body {
                font-family: 'Roboto', sans-serif;
                background-color: #f8f9fa;
            }
            .card {
                border-radius: 15px;
                padding: 30px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            }
            .toggle-link {
                cursor: pointer;
                color: #0d6efd;
                text-decoration: underline;
            }
            .toggle-link:hover {
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <!-- Mostrar mensaje de error -->
    <c:if test="${not empty error}">
        <div class="alert alert-danger text-center" role="alert">
            ${error}
        </div>
    </c:if>
    <div class="d-flex align-items-center justify-content-center min-vh-100">
        <div class="card w-100" style="max-width: 400px;">
            <h2 id="form-title" class="text-center text-primary mb-4">Iniciar sesión</h2>
            <form id="login-form" action="LoginServlet" method="POST">
                <!-- Input de correo -->
                <div class="mb-3">
                    <label for="email" class="form-label">Correo electrónico:</label>
                    <input type="email" id="email" name="correo" class="form-control" placeholder="Escribe tu correo" required>
                </div>
                <!-- Input de contraseña -->
                <div class="mb-3">
                    <label for="password" class="form-label">Contraseña:</label>
                    <input type="password" id="password" name="contrasena" class="form-control" placeholder="Escribe tu contraseña" required>
                </div>
                <!-- Botón para enviar -->
                <button type="submit" class="btn btn-primary w-100">Iniciar sesión</button>
            </form>

            <!-- Sección de registro -->
            <form id="register-form" action="RegistroServlet" method="POST" style="display: none;">
                <h2 class="text-center text-primary mb-4">Crear cuenta</h2>
                <!-- Input de nombre -->
                <div class="mb-3">
                    <label for="name" class="form-label">Nombre:</label>
                    <input type="text" id="name" name="nombre" class="form-control" placeholder="Escribe tu nombre" required>
                </div>
                <!-- Input de correo -->
                <div class="mb-3">
                    <label for="register-email" class="form-label">Correo electrónico:</label>
                    <input type="email" id="register-email" name="correoElectronico" class="form-control" placeholder="Escribe tu correo" required>
                </div>
                <!-- Input de contraseña -->
                <div class="mb-3">
                    <label for="register-password" class="form-label">Contraseña:</label>
                    <input type="password" id="register-password" name="contrasena" class="form-control" placeholder="Crea una contraseña" required>
                </div>
                <!-- Botón para enviar -->
                <button type="submit" class="btn btn-primary w-100">Registrar</button>
            </form>

            <!-- Toggle entre login y registro -->
            <p class="text-center mt-3">
                <a id="toggle-link" class="toggle-link" onclick="toggleForms()">¿No tienes cuenta? Regístrate</a>
            </p>
        </div>
    </div>
    <script>
        // Alternar entre formulario de login y registro
        function toggleForms() {
            const loginForm = document.getElementById('login-form');
            const registerForm = document.getElementById('register-form');
            const toggleLink = document.getElementById('toggle-link');

            if (loginForm.style.display === 'none') {
                loginForm.style.display = 'block';
                registerForm.style.display = 'none';
                toggleLink.textContent = '¿No tienes cuenta? Regístrate';
            } else {
                loginForm.style.display = 'none';
                registerForm.style.display = 'block';
                toggleLink.textContent = '¿Ya tienes cuenta? Inicia sesión';
            }
        }
    </script>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
