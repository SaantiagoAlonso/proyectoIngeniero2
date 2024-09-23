// document.getElementById('btnActualizar').addEventListener('click', async function(event) {
//     event.preventDefault();

//     // Obtén el JWT del almacenamiento local
//     const jwt = localStorage.getItem('jwt');

//     // Obtén los valores del formulario

//     const id = document.getElementById('id_user').value;
//     const username = document.getElementById('username').value;
//     const email = document.getElementById('email').value;
//     const age = parseInt(document.getElementById('edad').value);
//     const rol = document.getElementById('rol').value;


//     // Crea el objeto newUser con los datos del formulario
//     const uptateUser = {
//         id: id,
//         username: username,
//         email: email,
//         age: age,
//         rol: rol
//     };

//     try {
//         const response = await fetch('http://localhost:8080/user/updateUser', {
//             method: 'PUT',
//             headers: {
//                 'Content-Type': 'application/json',
//                 // Incluye el JWT en los encabezados si está disponible
//                 'Authorization': jwt ? `Bearer ${jwt}` : ''
//             },
//             body: JSON.stringify(uptateUser)
//         });

//         if (response.ok) {
//             const result = await response.json();
//             alert('Usuario actualizado con éxito.');
//             // Puedes redirigir al usuario o limpiar el formulario
//             window.location.href = "/hola.html"; // Redirigir a la página de inicio de sesión
//         } else {
//             const error = await response.json();
//             alert('Error al actualizar el usuario: ' + error.message);
//         }
//     } catch (error) {
//         console.error('Error:', error);
//         alert('Ocurrió un error al intentar actualizar el usuario.');
//     }
// });
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('btnActualizar').addEventListener('click', async function(event) {
        event.preventDefault(); // Evita el comportamiento por defecto del formulario

        // Obtén el JWT del almacenamiento local
        const jwt = localStorage.getItem('jwt');

        // Obtén los valores del formulario
        const id = document.getElementById('id_user').value;
        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const age = parseInt(document.getElementById('age').value); // Asegúrate de que el ID sea 'age', no 'edad'
        const rol = document.getElementById('rol').value;

        // Crea el objeto updateUser con los datos del formulario
        const updateUser = {
            id: id,
            username: username,
            email: email,
            age: age,
            rol: rol
        };

        try {
            const response = await fetch('http://localhost:8080/user/updateUser', {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json',
                    // Incluye el JWT en los encabezados si está disponible
                    'Authorization': jwt ? `Bearer ${jwt}` : ''
                },
                body: JSON.stringify(updateUser)
            });

            if (response.ok) {
                const result = await response.json();
                alert('Usuario actualizado con éxito.');
                // Puedes redirigir al usuario o limpiar el formulario
                window.location.href = "/hola.html"; // Redirigir a la página de éxito
            } else {
                const error = await response.json();
                alert('Error al actualizar el usuario: ' + error.message);
            }
        } catch (error) {
            console.error('Error:', error);
            alert('Ocurrió un error al intentar actualizar el usuario.');
        }
    });
});
