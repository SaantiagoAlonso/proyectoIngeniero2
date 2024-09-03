document.getElementById('register').addEventListener('click', async function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const age = parseInt(document.getElementById('edad').value);
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirm-password').value;

    if (password !== confirmPassword) {
        alert('Las contraseñas no coinciden.');
        return;
    }

    const newUser = {
        username: username,
        email: email,
        age: age,
        password: password
    };

    try {
        const response = await fetch('http://localhost:8080/user/registrationUser', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newUser)
        });

        if (response.ok) {
            const result = await response.json();
            alert('Usuario registrado con éxito.');
            // Puedes redirigir al usuario o limpiar el formulario
            window.location.href = "/index.html"; // Redirigir a la página de inicio de sesión
        } else {
            const error = await response.json();
            alert('Error al registrar el usuario: ' + error.message);
        }
    } catch (error) {
        console.error('Error:', error);
        alert('Ocurrió un error al intentar registrar el usuario.');
    }
});
