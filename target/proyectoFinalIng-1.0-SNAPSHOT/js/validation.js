// Validación del formulario de login
document.getElementById('login-form').addEventListener('submit', function(event) {
    // Obtener los valores de los campos
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Validación de correo electrónico
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!email || !emailRegex.test(email)) {
        alert("Por favor, ingresa un correo electrónico válido.");
        event.preventDefault();  // Detener el envío del formulario
        return;
    }

    // Validación de contraseña
    if (!password || password.length < 6) {
        alert("La contraseña debe tener al menos 6 caracteres.");
        event.preventDefault();  // Detener el envío del formulario
    }
});

// Validación del formulario de registro
document.getElementById('register-form').addEventListener('submit', function(event) {
    // Obtener los valores de los campos
    const name = document.getElementById('name').value;
    const email = document.getElementById('register-email').value;
    const password = document.getElementById('register-password').value;

    // Validación de nombre
    if (!name || name.trim() === "") {
        alert("Por favor, ingresa tu nombre.");
        event.preventDefault();
        return;
    }

    // Validación de correo electrónico
    const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!email || !emailRegex.test(email)) {
        alert("Por favor, ingresa un correo electrónico válido.");
        event.preventDefault();
        return;
    }

    // Validación de contraseña
    if (!password || password.length < 6) {
        alert("La contraseña debe tener al menos 6 caracteres.");
        event.preventDefault();
        return;
    }
});
