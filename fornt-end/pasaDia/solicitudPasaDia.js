document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita el comportamiento por defecto del formulario

    // Capturar los datos del formulario
    const nombre = document.getElementById('nombre-pasadía').value;
    const email = document.getElementById('email-pasadía').value;
    const fechaVisita = document.getElementById('fecha-visita').value;
    const tipoServicio = document.getElementById('tipo-servicio').value;
    const comentarios = document.getElementById('comentarios').value;

    // Crear el objeto de solicitud con los datos del formulario
    const solicitudPasaDia = {
        nombre: nombre,
        email: email,
        fechaVisita: fechaVisita,
        servicio: tipoServicio,
        comentario: comentarios
    };

    // Hacer la solicitud POST al backend
    fetch('http://localhost:8080/pasaDia/solicitarPasaDia', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(solicitudPasaDia)
    })
    .then(response => response.json())
    .then(data => {
        alert(data.mensaje); // Mensaje de respuesta del servidor
    })
    .catch(error => console.error('Error:', error));
});
